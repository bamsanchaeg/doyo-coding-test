package doyoCodingtest.DoyoBaekJoon.test2024;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ17204_1117 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 처리
        int N = scanner.nextInt(); // 사람의 수
        int K = scanner.nextInt(); // 보성이의 번호
        int[] targets = new int[N]; // 지목 대상 저장

        for (int i = 0; i < N; i++) {
            targets[i] = scanner.nextInt();
        }

        // 결과 계산
        int result = findMinM(N, K, targets);
        System.out.println(result);
    }

    public static int findMinM(int N, int K, int[] targets) {
        boolean[] visited = new boolean[N]; // 방문 여부 체크
        Queue<int[]> queue = new LinkedList<>(); // BFS 큐
        queue.add(new int[]{0, 1}); // 0번부터 시작, 카운트는 1
        visited[0] = true; // 0번 방문 처리

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int person = current[0];
            int count = current[1];

            // 보성이(K번)에게 도달한 경우
            if (person == K) {
                return count;
            }

            // 다음 노드 탐색
            int nextPerson = targets[person];
            if (!visited[nextPerson]) {
                visited[nextPerson] = true;
                queue.add(new int[]{nextPerson, count + 1});
            }
        }

        // 보성이에게 도달할 수 없는 경우
        return -1;
    }
}
