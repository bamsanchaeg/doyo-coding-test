package doyoCodingtest.DoyoBaekJoon.test2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11724_1209_DFS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>()); //인접 리스트 초기화
        }

        //간선의 양 끝점 u와 v가 주어진다
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u); //연결 요소를 서로 연결
        }

        boolean[] visited = new boolean[N + 1];
        int connectedComponents = 0;

        //DFS 탐색 함수
        for (int i = 1; i <= N; i++){
            if(!visited[i]){
                dfs(i, graph, visited);
                connectedComponents++;
            }
        }

        System.out.println(connectedComponents);
    }

    //현재 노드를 방문 처리하고, 해당 노드와 연결된 모든 인접 노드에 대해 재귀 호출
    //모든 노드에 대해 재귀적으로 탐색하여 연결된 모든 노드를 방문한다.
    private static void dfs (int node, List<List<Integer>> graph, boolean[] visited){
        visited[node] = true;
        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, graph,visited);
            }
        }
    }
}
