package doyoCodingtest;

import java.util.*;
import java.io.*;

public class BOJ25418_1023 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());  // 시작 정수 A
        int K = Integer.parseInt(st.nextToken());  // 목표 정수 K

        // BFS를 위한 큐와 방문 체크 배열
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[K + 1];

        // 초기 상태 삽입 (정수 A와 현재 연산 횟수 0)
        queue.offer(new int[] {A, 0});
        visited[A] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int num = current[0];   // 현재 정수
            int count = current[1]; // 현재까지의 연산 횟수

            // K에 도달한 경우 연산 횟수 출력하고 종료
            if (num == K) {
                System.out.println(count);
                return;
            }

            // 1을 더하는 연산
            if (num + 1 <= K && !visited[num + 1]) {
                visited[num + 1] = true;
                queue.offer(new int[] {num + 1, count + 1});
            }

            // 2를 곱하는 연산
            if (num * 2 <= K && !visited[num * 2]) {
                visited[num * 2] = true;
                queue.offer(new int[] {num * 2, count + 1});
            }
        }
    }
}
