package doyoCodingtest.DoyoBaekJoon.test2024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11060_1207 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] maze = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(minJumps(maze, N));

    }

    public static int minJumps(int[] maze, int N) {
        //BFS를 위한 큐 초기화
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        queue.add(new int[]{0, 0}); //시작위치, 점프 횟수
        visited[0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0]; //시작위치
            int jumps = current[1];//점프 횟수

            //가장 오른쪽 끝에 도달한 경우
            if (position == N - 1) {
                return jumps;
            }

            //현재 위치에서 점프 가능한 범위 탐색
            for (int next = position + 1; next <= position + maze[position] && next < N; next++) {
                if (!visited[next]) {
                    queue.add(new int[]{next, jumps + 1});
                    visited[next] = true;
                }
            }
        }

        //오른쪽 끝에 도달할 수 없는 경우
        return -1;
    }
}
