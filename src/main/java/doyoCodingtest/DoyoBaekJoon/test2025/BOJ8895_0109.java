package doyoCodingtest.DoyoBaekJoon.test2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8895_0109 {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        //DP 테이블 초기화
        int maxN = 20; // 문제에서 주어진 n의 최대값
        long[][][] dp = new long[maxN+1][maxN+1][maxN+1];

        //초기조건
        dp[1][1][1] = 1;


        // DP 계산
        for (int n = 2; n <= maxN; n++) {
            for (int l = 1; l <= n; l++) {
                for (int r = 1; r <= n; r++) {
                    // 점화식 적용
                    dp[n][l][r] += dp[n - 1][l - 1][r]; // 가장 왼쪽에 큰 막대 추가
                    dp[n][l][r] += dp[n - 1][l][r - 1]; // 가장 오른쪽에 큰 막대 추가
                    dp[n][l][r] += dp[n - 1][l][r] * (n - 2); // 중간에 작은 막대 추가
                    dp[n][l][r] %= 1_000_000_007; // 모듈러 연산
                }
            }
        }

        // 테스트 케이스 처리
        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" "); // 공백으로 구분된 한 줄 입력
            int n = Integer.parseInt(input[0]);
            int l = Integer.parseInt(input[1]);
            int r = Integer.parseInt(input[2]);

            // 결과 출력
            System.out.println(dp[n][l][r]);
        }

    }
}
