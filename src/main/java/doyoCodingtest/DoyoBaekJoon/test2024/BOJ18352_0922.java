package doyoCodingtest.DoyoBaekJoon.test2024;

import java.io.*;
import java.util.*;

public class BOJ18352_0922 {

    public static void main(String[] args)throws IOException {
        //특정 거리의 도시 찾기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); //도시의 개수
        int M = Integer.parseInt(st.nextToken()); //도로의 개수
        int K = Integer.parseInt(st.nextToken()); //목표 최단 거리
        int X = Integer.parseInt(st.nextToken()); //출발 도시

        //그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        //도시 개수만큼의 배열 입력, 도시번호가 1번부터 시작하기 때문에 배열을 N+1로 설정한다.
        for(int i = 0; i < N+1; i++){
            graph.add(new ArrayList<>());
        }

        //그래프에 단방향 도로 정보 삽입
        for(int i=0; i< M; i++){
            //한줄씩 입력받기 위해 해당 방법 사용
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            //graph에 A번 도시와 B번 도시로 이동하는 정보 추가
            graph.get(A).add(B);
        }

        //최단거리 배열 초기화
        int[] shortCut = new int[N+1];
        Arrays.fill(shortCut,-1);//-1은 아직 방문되지 않은 도시를 의미
        shortCut[X] = 0;// 출발도시는 거리 0

        //BFS 탐색을 위한 큐
        Queue<Integer> queue = new LinkedList<>();
        //출발 도시가 가장 먼저 큐에 들어간다.
        queue.add(X);

        //DFS 탐색 시작
        while (!queue.isEmpty()){
            int current = queue.poll();
            //인접노드 탐색(List 자료구조를 풀어주면서 탐색)
            for(int neighbor : graph.get(current)){
                if(shortCut[neighbor] == -1){ //아직 방문하지 않은 도시만 탐색
                    shortCut[neighbor] = shortCut[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        //최단 거리가 K인 도시를 출력
        boolean found = false;
        for(int i = 1; i<=N; i++){
            if(shortCut[i]==K){
                System.out.println(i);
                found = true;
            }
        }
        if(!found){
            System.out.println(-1);
        }

        br.close();
    }
}
