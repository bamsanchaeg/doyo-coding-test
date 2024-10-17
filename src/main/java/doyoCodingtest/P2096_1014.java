package doyoCodingtest;

import java.io.*;
import java.util.*;

public class P2096_1014 {

    static int N;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][3];
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<3; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //최대 점수를 위한 DP 배열
        int[] maxPrev = new int[3];
        int[] maxCurr = new int[3];
        //최소 점수를 위한 DP 배열
        int[] minPrev = new int[3];
        int[] minCurr = new int[3];

        //첫번째 줄 초기화
        for(int j=0; j<3; j++){
            maxPrev[j] = board[0][j];
            minPrev[j] = board[0][j];
        }

        //DP 계산
        for(int i = 1; i<N; i++){
            // 최대 점수
            maxCurr[0] = Math.max(maxPrev[0], maxPrev[1]) + board[i][0];
            maxCurr[1] = Math.max(Math.max(maxPrev[0], maxPrev[1]), maxPrev[2]) + board[i][1];
            maxCurr[2] = Math.max(maxPrev[1], maxPrev[2]) + board[i][2];

            // 최소 점수
            minCurr[0] = Math.min(minPrev[0], minPrev[1]) + board[i][0];
            minCurr[1] = Math.min(Math.min(minPrev[0], minPrev[1]), minPrev[2]) + board[i][1];
            minCurr[2] = Math.min(minPrev[1], minPrev[2]) + board[i][2];

            // 현재 값을 이전 값으로 업데이트
            System.arraycopy(maxCurr, 0, maxPrev, 0, 3);
            System.arraycopy(minCurr, 0, minPrev, 0, 3);
        }

        // 최대값과 최소값 구하기
        int maxScore = Math.max(Math.max(maxPrev[0], maxPrev[1]), maxPrev[2]);
        int minScore = Math.min(Math.min(minPrev[0], minPrev[1]), minPrev[2]);

        System.out.println(maxScore + " " + minScore);


    }
}
