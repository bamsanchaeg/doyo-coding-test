package doyoCodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1464_1206 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1]; // dp[i]는 i를 1로 만드는데 필요한 최소 연산 횟수

        // 초기화
        dp[1] = 0; // 숫자 1은 이미 목표 상태

        // DP 점화식 계산
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 기본적으로 1을 뺀 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 2로 나눌 수 있는 경우
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 3으로 나눌 수 있는 경우
            }
        }

        // 결과 출력
        System.out.println(dp[N]);
    }

}
