package doyoCodingtest.DoyoBaekJoon.test2024;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ5212_0918 {

    static int R, C;
    static char[][] board;
    static int[] dx = {0, 1, 0, -1};  // 방향 배열 (위, 오른쪽, 아래, 왼쪽)
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 문제의 input을 받는다.
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        board = new char[R][C];

        //바다의 정보 기입, 열로 정보를 받는다.
        for(int i =0; i<R; i++){
            board[i] = br.readLine().toCharArray();
        }

        List<int[]> sink = new ArrayList<>();

        //섬의 위치마다 인접한 바다의 개수를 구하고, 잠길 곳을 기록한다.
        //행열의 요소마다 탐색하면서 'X'인 요소를 찾을 시 정보를 더함
        for(int i = 0; i<R; i++){
            for(int j=0; j<C; j++){
                if(board[i][j] == 'X'){
                    if(checkSea(i,j) >= 3){
                        sink.add(new int[]{i,j});
                    }
                }
            }
        }


        // 3. 잠긴 곳의 정보를 토대로 지도를 업데이트 한다. List 자료구조
        for (int[] pos : sink) {
            int x = pos[0];
            int y = pos[1];
            board[x][y] = '.';
        }

        // 4. 출력해야 할 지도의 최소 크기를 구한다. Math.min/max 사용
        int minX = R, maxX = 0, minY = C, maxY = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'X') {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        // 5. 최소 크기에 맞게 지도를 출력한다.
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }

    // 6. 인접한 바다의 개수를 구하는 메서드
    public static int checkSea(int x, int y) {
        int count = 0;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                count++;
            } else if (board[nx][ny] == '.') {
                count++;
            }
        }
        return count;
    }
}
