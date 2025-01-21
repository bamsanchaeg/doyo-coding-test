package doyoCodingtest.DoyoBaekJoon.test2024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ10422_0106 {
    static int T, MUL = 1000000007;    // 나머지를 구하기 위해 나누는 값
    static long[] DP = new long[5001];  // 최대 5000까지 계산할 DP 배열

    public static void main(String[] args) throws IOException {
        // 입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 수 입력
        T = Integer.parseInt(br.readLine());

        // DP 배열 초기화
        init();    // DP 계산을 위한 함수 호출

        // T개의 테스트 케이스에 대해 DP[L] 값 출력
        for (int i = 0; i < T; i++) {
            int L = Integer.parseInt(br.readLine());
            bw.write(DP[L] + "\n");  // DP[L] 값을 BufferedWriter에 기록
        }

        // 결과 출력
        bw.flush();
        bw.close();
        br.close();
    }

    // DP 배열을 채우는 함수
    static void init() {
        DP[0] = DP[2] = 1;    // 초기값 설정: DP[0] = 1, DP[2] = 1

        // DP 배열 계산 (길이가 4부터 5000까지 2씩 증가하면서 계산)
        for (int i = 4; i <= 5000; i += 2) {
            for (int j = 0; j < i; j += 2) {
                DP[i] += DP[j] * DP[i - j - 2];  // 점화식 적용
                DP[i] %= MUL;  // 모듈러 연산 (1000000007로 나누기)
            }
        }
    }
}
