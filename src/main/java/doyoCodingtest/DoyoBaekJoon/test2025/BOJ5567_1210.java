package doyoCodingtest.DoyoBaekJoon.test2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5567_1210 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Integer>> friends = new ArrayList<>();
        for(int i = 0; i<=N; i++){
            friends.add(new ArrayList<>());
        }
        //친구 관계 입력

        for(int i = 0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        System.out.println(getInvitesCount(friends,N));

    }

    private static int getInvitesCount(List<List<Integer>> graph, int N){
        boolean[] visited = new boolean[N + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,0}); //상근이부터 시작(노드, 거리)
        visited[1] = true;

        int count = 0;

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int node = current[0];
            int distance = current[1];

            if(distance>2){
                break; //2촌 초과면 탐색 종료
            }

            for(int friend : graph.get(node)){
                if(!visited[friend]){
                    visited[friend] = true;
                    queue.add(new int[]{friend, distance+1});
                    if(distance + 1 <=2){
                        count++; //2촌 이내인 경우에만 초대
                    }
                }
            }
        }
        return count;
    }
}
