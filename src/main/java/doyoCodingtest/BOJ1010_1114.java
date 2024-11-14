package doyoCodingtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ1010_1114 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] cases = new int[T][2];
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cases[i][0] = Integer.parseInt(st.nextToken());
            cases[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < T; i++) {
            int N = cases[i][0];
            int M = cases[i][1];

            BigInteger factorialM = BigInteger.ONE;
            BigInteger factorialN = BigInteger.ONE;
            BigInteger factorialMMinusN = BigInteger.ONE;

            // M! 계산
            for (int j = 1; j <= M; j++) {
                factorialM = factorialM.multiply(BigInteger.valueOf(j));
            }

            // N! 계산
            for (int j = 1; j <= N; j++) {
                factorialN = factorialN.multiply(BigInteger.valueOf(j));
            }

            // (M - N)! 계산
            for (int j = 1; j <= (M - N); j++) {
                factorialMMinusN = factorialMMinusN.multiply(BigInteger.valueOf(j));
            }

            // 조합 계산: C(M, N) = M! / (N! * (M - N)!)
            BigInteger combination = factorialM.divide(factorialN.multiply(factorialMMinusN));

            // 결과 출력
            bw.write(combination + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
