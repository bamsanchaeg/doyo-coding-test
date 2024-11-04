package doyoCodingtest;

import java.io.*;
import java.util.*;

public class BOJ2467_1022 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 용액의 수
        int[] solutions = new int[N];  // 용액 특성값을 저장하는 배열

        // 용액의 특성값 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터 설정
        int left = 0;
        int right = N - 1;
        int closestSum = Integer.MAX_VALUE;  // 가장 0에 가까운 합을 저장
        int answerLeft = 0;  // 결과로 출력할 왼쪽 용액
        int answerRight = 0;  // 결과로 출력할 오른쪽 용액

        // 투 포인터로 0에 가장 가까운 합 찾기
        while (left < right) {
            int sum = solutions[left] + solutions[right];  // 두 용액의 합

            // 현재 합이 0에 더 가까운 경우
            if (Math.abs(sum) < Math.abs(closestSum)) {
                closestSum = sum;  // 가장 0에 가까운 합으로 갱신
                answerLeft = solutions[left];
                answerRight = solutions[right];
            }

            // 합이 0보다 크면 오른쪽 포인터를 왼쪽으로
            if (sum > 0) {
                right--;
            }
            // 합이 0보다 작으면 왼쪽 포인터를 오른쪽으로
            else {
                left++;
            }
        }

        // 오름차순 출력
        System.out.println(answerLeft + " " + answerRight);
    }
}
