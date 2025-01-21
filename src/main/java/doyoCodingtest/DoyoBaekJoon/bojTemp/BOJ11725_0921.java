package doyoCodingtest.DoyoBaekJoon.bojTemp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11725_0921 {

    static int N; //노드 수
    static List<Integer>[] tree; //인접 리스트
    static int[] parent; //부모를 저장할 배열
    static boolean[] visited; //방문여부

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //인접 리스트 초기화
        tree = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            tree[i] = new ArrayList<>();
        }

        //트리 간선 입력
        for(int i=0; i <N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u); // 양방향 연결
        }

        //부모 저장 배열과 방문 배열 초기화
        parent = new int[N+1];
        visited = new boolean[N+1];

        //1번 노드를 루트로 하여 DFS 시작
        dfs(1);

        //각 노드의 부모 출력(2번 노드부터 출력)
        for(int i = 2; i<=N; i++){
            System.out.println(parent[i]);
        }
    }

    static void dfs(int node){
        visited[node]=true;

        //인접한 노드를 확인
        for(int next:tree[node]){
            if(!visited[next]){
                parent[next] = node;
                dfs(next);
            }
        }
    }
}
