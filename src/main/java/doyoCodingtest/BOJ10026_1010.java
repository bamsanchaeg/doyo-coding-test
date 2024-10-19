package doyoCodingtest;

import java.util.*;
import java.io.*;

public class BOJ10026_1010 {
    static char[][] grid;
    static int N;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                grid[i][j] = line.charAt(j); // 각 문자를 char 배열에 저장
            }
        }

        int regionCount = 0;
        int colorWeakRegionCount = 0;

        //두 개의 grid 배열 사용(하나는 원본, 하나는 색맹 처리)
        char[][] colorWeakGrid = new char[N][N];

        // 원본과 색맹 처리를 위한 그리드를 복사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                colorWeakGrid[i][j] = grid[i][j];
                // 색맹의 경우 'G'를 'R'로 처리
                colorWeakGrid[i][j] = (grid[i][j] == 'G') ? 'R' : grid[i][j];
            }
        }


        //모든 칸에 대해 BFS 탐색 시작
        for(int i=0; i< N; i++){
            for(int j =0; j< N; j++){
                //아직 방문하지 않은 구역이라면 해당 문자의 구역을 탐색
                if(grid[i][j] != '1'){
                    bfs(i,j,grid);
                    regionCount++;
                }
            }
        }

        //색맹인 경우 grid에 대해 탐색
        // 색맹의 경우 그리드에 대해 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (colorWeakGrid[i][j] != '1') {
                    bfs(i, j, colorWeakGrid);  // 색맹의 경우
                    colorWeakRegionCount++;  // 색맹 구역 카운트 증가
                }
            }
        }

        System.out.println(regionCount + " " + colorWeakRegionCount);
        br.close();

    }

    public static void bfs(int x, int y, char[][] grid){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        char targetChar = grid[x][y]; //시작점의 문자 기록
        grid[x][y] = '1';// 현재 칸을 방문 처리

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            //상하좌우로 이동하며 동일 문자를 찾음
            for(int i =0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                //범위를 벗어나지 않고, 동일 문자이면서 방문하지 않은 칸이라면 탐색
                // 지도 밖을 넘어가지 않았는지 확인
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && grid[nx][ny] == targetChar) {
                    grid[nx][ny] = '1'; // 방문 표시, char의 경우 문자열 처리에 주의
                    queue.add(new int[]{nx, ny});
                }
            }
        }

    }
}
