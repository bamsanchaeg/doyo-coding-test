package doyoCodingtest.DoyoBaekJoon.test2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2473_0111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sol = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sol[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 정렬
        Arrays.sort(sol);

        // 초기값 설정
        long closestSum = Long.MAX_VALUE; // 최적 합 저장
        int[] result = new int[3]; // 결과 저장 배열

        // 첫 번째 용액을 고정
        for (int k = 0; k < N - 2; k++) {
            int i = k + 1; // 두 번째 포인터
            int j = N - 1; // 세 번째 포인터

            while (i < j) {
                long sum = (long) sol[k] + sol[i] + sol[j]; // 세 용액의 합 계산

                // 현재 합이 더 0에 가까우면 결과 갱신
                if (Math.abs(sum) < Math.abs(closestSum)) {
                    closestSum = sum;
                    result[0] = sol[k];
                    result[1] = sol[i];
                    result[2] = sol[j];
                }

                // 합이 0보다 크면, j를 줄여 더 작은 값 탐색
                if (sum > 0) {
                    j--;
                }
                // 합이 0보다 작으면, i를 늘려 더 큰 값 탐색
                else if (sum < 0) {
                    i++;
                }
                // 합이 정확히 0이면 최적값이므로 즉시 종료
                else {
                    result[0] = sol[k];
                    result[1] = sol[i];
                    result[2] = sol[j];
                    break;
                }
            }
        }

        // 결과 출력 (오름차순)
        Arrays.sort(result);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }

}
