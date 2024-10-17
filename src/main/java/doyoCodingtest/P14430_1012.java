package doyoCodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14430_1012 {

    static int N,M;
    static int[][] DP;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j< M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //DP 배열 초기화
        DP = new int[N][M];

        // 3. 세운 점화식에 맞게 DP 탐색을 진행합니다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) {
                    DP[i][j] = board[i][j];
                } else if (i == 0) {
                    DP[i][j] = DP[i][j - 1] + board[i][j];
                } else if (j == 0) {
                    DP[i][j] = DP[i - 1][j] + board[i][j];
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]) + board[i][j];
                }
            }
        }


        System.out.println(DP[N - 1][M - 1]);

    }

}
