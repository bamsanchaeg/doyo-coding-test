package doyoCodingtest.DoyoBaekJoon.test2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1562_0108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(countSteppingNumbers(N));
    }

    public static int countSteppingNumbers(int N) {
        int MOD = 1_000_000_000;
        int FULL_MASK = (1 << 10) - 1;
        int[][][] dp = new int[N + 1][10][1024]; // dp[pos][digit][mask]

        //초기화 : 길이가 1인 경우(0으로 시작하는 숫자는 제외)
        for (int digit = 1; digit <= 9; digit++) {
            dp[1][digit][1 << digit] = 1;
        }

        // DP 진행
        for (int pos = 1; pos < N; pos++) {
            for (int digit = 0; digit <= 9; digit++) {
                for (int mask = 0; mask <= FULL_MASK; mask++) {
                    if (dp[pos][digit][mask] == 0) {
                        continue;
                    }

                    // 다음 숫자로 이동
                    if (digit > 0) {
                        int nextMask = mask | (1 << (digit - 1));
                        dp[pos + 1][digit - 1][nextMask] =
                                (dp[pos + 1][digit - 1][nextMask] + dp[pos][digit][mask]) % MOD;
                    }
                    if (digit < 9) {
                        int nextMask = mask | (1 << (digit + 1));
                        dp[pos + 1][digit + 1][nextMask] =
                                (dp[pos + 1][digit + 1][nextMask] + dp[pos][digit][mask]) % MOD;
                    }
                }
            }
        }

        // 결과 계산: 길이가 N이고, mask가 FULL_MASK인 경우
        int result = 0;
        for (int digit = 0; digit <= 9; digit++) {
            result = (result + dp[N][digit][FULL_MASK]) % MOD;
        }

        return result;
    }
}
