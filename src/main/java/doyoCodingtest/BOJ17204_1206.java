package doyoCodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17204_1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]); // 참여자 수
        int K = Integer.parseInt(firstLine[1]); // 보성의 번호

        // 두 번째 줄부터 N개의 줄 입력
        int[] targets = new int[N];
        for (int i = 0; i < N; i++) {
            targets[i] = Integer.parseInt(br.readLine());
        }

        // 방문 배열 초기화
        boolean[] visited = new boolean[N];
        int current = 0; // 현재 노드
        int count = 0; // 이동 횟수 (M)

        while (!visited[current]) {
            if (current == K) { // 보성에게 도달한 경우
                System.out.println(count);
                return;
            }
            visited[current] = true; // 현재 노드 방문 처리
            current = targets[current]; // 다음 노드로 이동
            count++; // 이동 횟수 증가

        }

        // 보성에게 도달하지 못한 경우
        System.out.println("-1");
    }
}
