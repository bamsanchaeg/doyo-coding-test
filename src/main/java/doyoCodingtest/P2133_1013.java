package doyoCodingtest;


/**
 * 	1. 타일을 세로로 배치:
 * 	   1개의 2×1 타일을 세로로 배치하면, 3×(n-1) 크기의 벽이 남습니다.
 * 	이 경우는 3×(n-1) 벽을 채우는 경우의 수인 dp[n-1]에 해당합니다.
 * 	2. 타일을 가로로 배치:
 * 	   3×2 크기의 영역을 가로로 채우는 경우가 있습니다.
 * 	   3×2 벽은 다음과 같은 방식으로 타일을 배치할 수 있습니다:
 * 	   2개의 1×2 타일을 위아래로 배치하고, 나머지 3×(n-2) 벽을 채우는 경우 (dp[n-2]).
 * 	   3개의 1×2 타일을 수평으로 배치하는 경우도 가능하지만,
 * 	   이 경우에는 3개의 1×2 타일이 모두 겹치게 되므로 3×2 벽을 채우는 경우로 간주됩니다.
 *     이 경우는 단순히 1가지입니다.

 * 따라서 최종적으로 다음과 같은 점화식이 됩니다:

 * dp[n] = dp[n-1] + dp[n-2] * 3
 * **/

/*
 * 초기값
 * 	dp[0] = 1: 3×0 크기 벽(타일이 없는 경우)
 * 	dp[1] = 0: 3×1 크기는 2×1 또는 1×2 타일로 채울 수 없습니다.
 * 	dp[2] = 3: 3×2 크기는 다음과 같은 경우로 채울 수 있디:
 * 	1.	2개의 1×2 타일을 세로로 배치
 * 	2.	1개의 2×1 타일을 두 개 가로로 배치
 * 	3.	3개의 1×2 타일을 수평으로 배치
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2133_1013 {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
    }
}
