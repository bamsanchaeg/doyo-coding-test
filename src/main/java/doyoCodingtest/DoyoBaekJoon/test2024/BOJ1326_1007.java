package doyoCodingtest.DoyoBaekJoon.test2024;

import java.io.*;
import java.util.*;

public class BOJ1326_1007 {

    static int N;
    static int[] numbers;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        numbers = new int[N];


        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        //a번 징검다리에서 시작해 B번 징검다리의 수로 가기, 여기서 A의 배수만큼 점프가 가능하다.
        //징검다리의 번호는 1번 징검다리부터 시작하지만, 배열에서는 0번 인덱스부터 시작하니 -1을 제거하고 시작한다.
        st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken())-1;
        int b = Integer.parseInt(st.nextToken())-1;

        int result = jumpsBfs(numbers, a, b);
        System.out.println(result);


    }


    public static int jumpsBfs(int[] numbers, int start, int target){
        int n = numbers.length;
        boolean[] visited = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();

        //시작 지점 큐에 삽입(현재 위치, 점프 횟수)
        queue.offer(new int[]{start,0});
        visited[start] = true;

        while (!queue.isEmpty()){
            //queue의 가장 앞 요소를 제거하고 반환함
            //큐가 비어 있을 때 예외를 던지는 remove()와의 차이점: poll()은 Queue가 비어 있을 경우 null을 반환하지만, remove()는 NoSuchElementException을 던진다
            int[] current = queue.poll();
            int position = current[0];
            int jumps = current[1];

            //목표 징검다리에 도달했을 경우 점프 횟수 반환
            if(position == target){
                return jumps;
            }

            //현재 위치에서 점프할 수 있는 위치들을 모두 탐색
            int step = numbers[position];
            for(int next = position + step; next< n; next += step){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(new int[]{next, jumps + 1});
                }
            }

            //현재 위치에서 뒤로 갈 수 있는 위치들 탐색
            for(int next = position - step; next>=0; next-= step){
                if(!visited[next]){
                    visited[next]=true;
                    queue.offer(new int[]{next, jumps + 1});
                }
            }
        }

        //목표 지점에 도달할 수 없는 경우
        return -1;
    }
}
