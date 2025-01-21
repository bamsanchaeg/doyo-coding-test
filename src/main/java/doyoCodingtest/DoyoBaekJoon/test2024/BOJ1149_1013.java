package doyoCodingtest.DoyoBaekJoon.test2024;

import java.io.*;
import java.util.*;

public class BOJ1149_1013 {

    static int N;
    static int[][] cost;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        cost = new int[N][3];

        for(int i=0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            cost[i][0] = Integer.parseInt(st.nextToken()); //빨강으로 칠하는 비용
            cost[i][1] = Integer.parseInt(st.nextToken()); //초록으로 칠하는 비용
            cost[i][2] = Integer.parseInt(st.nextToken()); //파랑으로 칠하는 비용
        }

        //DP 테이블 초기화
        int[][] dp = new int[N][3];
        dp[0][0] = cost[0][0]; //1번 집을 빨강으로 칠했을 때
        dp[0][1] = cost[0][1]; //1번 집을 초록으로 칠했을 때
        dp[0][2] = cost[0][2]; //1번 집을 파랑으로 칠했을 때

        //DP 계산
        //i번째 집을 색깔 0,1,2로 칠하는 최소 비용을 의미하며, 각각 빨강, 초록, 파랑을 나타냅니다
        for(int i=1; i<N; i++){
            // Math.min(a, b): 두 값 a와 b 중 작은 값을 반환하는 Java의 내장 메소드
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + cost[i][0];//빨강
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + cost[i][1];//초록
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + cost[i][2];//파랑
        }

        // 최소 비용 계산
        //	1. dp[N-1][0]: 마지막 집을 빨강으로 칠했을 때의 최소 비용
        //	2. dp[N-1][1]: 마지막 집을 초록으로 칠했을 때의 최소 비용
        //	3. dp[N-1][2]: 마지막 집을 파랑으로 칠했을 때의 최소 비용
        int result = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));

        // 수정된 로직 적용 (문제 발생 시 최솟값 출력)
        System.out.println(result);


    }
}
