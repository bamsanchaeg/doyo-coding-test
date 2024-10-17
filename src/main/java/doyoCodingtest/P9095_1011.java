package doyoCodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9095_1011 {

    static int N;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //DP 배열 선언
        int[] results = new int[N];



        //테스트 케이스 별로 입력 받고 결과 계산
        for(int i =0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            results[i] = countMethods(n);
        }

        for(int i =0; i<N; i++){
            System.out.println(results[i]);
        }
        br.close();

    }

    public static int countMethods(int n){
        if(n == 0) return -1;

        int[] dp = new int[n+1];
        dp[0] = 1; //아무것도 더하지 않는 경우

        //DP 채우기
        for(int i =1; i<= n; i++){
            if(i>=1) dp[i] += dp[i-1];
            if(i>=2) dp[i] += dp[i-2];
            if(i>=3) dp[i] += dp[i-3];
        }

        return dp[n];

    }
}
