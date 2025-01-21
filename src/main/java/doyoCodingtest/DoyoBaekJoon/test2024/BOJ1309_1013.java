package doyoCodingtest.DoyoBaekJoon.test2024;

/**
 dp[i] 는 다음과 같은 방식으로 정의될 수 있다.
 1.	i번째 칸에 사자를 아예 배치하지 않는 경우: 이 경우는 이전 배열인  dp[i-1] 의 상태와 동일
 2.	i번째 칸에 사자를 하나만 배치하는 경우: 이 경우는 i-1번째 칸에서 사자를 배치하지 않은 상태에서만 가능
 3.	i번째 칸에 두 마리를 배치하는 경우: 사자들이 i-1번째와 i번째 칸에 인접하지 않도록 배치해야 하므로 i번째 칸의 양쪽 열에 사자를 배치.
 4. 따라서 점화식은 다음과 같다: dp[i] = (dp[i-1]*2) + (dp[i-2]*1) **/


import java.io.*;

public class BOJ1309_1013 {
    static int N;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //DP 배열 초기화
        int[] dp = new int[N+1];

        //초기값 설정
        dp[0]=1; // 2x0 배열에서 사자를 배치하지 않는 경우 (1가지)
        dp[1]=3; // 2x1 배열에서 사자를 배치하는 경우 (3가지)

        //DP 계산
        //DP 배열의 크기를  N+1 로 설정하고, 반복문에서  i < N  조건을 사용하면  dp[N] 의 값을 계산하지 못한다.
        //오버플로우 방지로 for 문에서 9901로 나눠준다.
        for(int i = 2; i<=N; i++){
            dp[i] = (dp[i-1]*2 + dp[i-2]) %9901;//점화식 적용
        }

        System.out.println(dp[N]);

    }
}
