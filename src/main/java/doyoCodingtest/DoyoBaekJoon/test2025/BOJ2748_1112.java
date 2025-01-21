package doyoCodingtest.DoyoBaekJoon.test2025;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2748_1112 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // System.out을 감싸줌
        int N = Integer.parseInt(br.readLine());

        //N이 90이하의 자연수이면 피보나치 수열의 값이 많이 커진다.
        long[] dp = new long[N + 1];
        //기본값 초기화
        dp[0] = 0;
        if(N>0) dp[1] = 1;

        //DP를 사용해 피보나치 수 계산
        for(int i = 2; i<= N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        // 결과를 BufferedWriter로 출력
        bw.write(dp[N] + "\n"); // 계산된 N번째 피보나치 수 출력
        bw.flush(); // 버퍼에 있는 데이터를 강제로 출력
        bw.close(); // 사용이 끝난 BufferedWriter를 닫음

    }
}
