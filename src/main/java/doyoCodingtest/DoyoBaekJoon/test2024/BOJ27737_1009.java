package doyoCodingtest.DoyoBaekJoon.test2024;

import java.util.*;
import java.io.*;

public class BOJ27737_1009 {

    static int N,M,K;
    static int[][] graph;
    static boolean[][] visited;//방문여부 기록
    static int[] dx = {-1,1,0,0};//상하좌우 탐색
    static int[] dy = {0,0,-1,1};//상하좌우 탐색

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //나무판 크기
        M = Integer.parseInt(st.nextToken()); //포자의 개수
        K = Integer.parseInt(st.nextToken()); //각 포자가 자랄 수 있는 최대 범위

        graph = new int[N][N];
        visited = new boolean[N][N];

        //농장 상태 입력 받기
        for(int i = 0; i <N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int usedMushrooms = 0 ;

        //포자심기 및 성장처리
        // 지도 위 모든 지점을 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 0) { // 농사를 짓는 곳이라면
                    int count = bfs(i, j); // 연결된 땅의 개수 탐색
                    usedMushrooms += count / K;
                    if (count % K != 0) {
                        usedMushrooms += 1;
                    }
                }
            }
        }

        if(usedMushrooms == 0){
            System.out.println("IMPOSSIBLE");
        } else if( usedMushrooms <= M){
            System.out.println("POSSIBLE");
            System.out.println(M - usedMushrooms);
        } else{
            System.out.println("IMPOSSIBLE");
        }

    }

    // BFS 탐색
    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        graph[x][y] = 1; // 방문 표시
        int count = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 지도 밖을 넘어가지 않았는지 확인
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && graph[nx][ny] == 0) {
                    graph[nx][ny] = 1; // 방문 표시
                    queue.add(new int[]{nx, ny});
                    count++;
                }
            }
        }
        return count;
    }


}
