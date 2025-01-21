package doyoCodingtest.DoyoBaekJoon.test2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ4803_0924 {

    static List<List<Integer>> graph;
    static boolean[] visited;
    static int N;
    static int M;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNumber = 1;//케이스 넘버

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break; // 입력 종료 조건

            //그래프 초기화, 제네릭 배열로 인한 경고창 발생.
            //제네릭 배열을 사용하는 대신 리스트 안에 리스트를 사용하는 것이 더 안전하다.
            graph = new ArrayList<>();
            for(int i =0; i<= N; i++){
                graph.add(new ArrayList<>());
            }

            //간선 입력 받기
            for(int i =0; i< M; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph.get(u).add(v);
                graph.get(v).add(u);//무방향 그래프이므로 양방향으로 추가
            }

            //트리 개수 찾기
            visited = new boolean[N + 1];
            int treeCount = 0;

            for(int i=1; i<=N; i++){
                if(!visited[i]){
                    if(dfs(i,-1)){
                        treeCount++;
                    }
                }
            }

            if(treeCount == 0){
                System.out.println("Case " + caseNumber + ": No trees.");
            }else if(treeCount == 1){
                System.out.println("Case " + caseNumber + ": There is one tree.");
            }else if(treeCount > 1){
                System.out.println("Case " + caseNumber + ": A forest of " + treeCount + " trees.");
            }

            caseNumber++;
        }

        br.close();

    }

    //DFS를 이용하여 연결된 모든 노드를 방문하여 트리 여부를 확인하는 함수
    public static boolean dfs(int node, int parent){
        //해당 노드를 방문했음을 기록
        visited[node] = true;
        boolean isTree = true;

        //현재 노드의 이웃 노드들을 하나씩 탐색함
        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                if(!dfs(neighbor, node)){
                    isTree = false; // 자식에서 사이클 발생 시 트리 아님
                }
            }else if(neighbor != parent){
                //부모가 아닌 이미 방문한 노드를 다시 만나면 사이클 존재
                isTree = false;
            }
        }
        return isTree;
    }
}
