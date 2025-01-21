package doyoCodingtest.DoyoBaekJoon.test2025;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


// 다시 풀으셔야 합니다...

public class BOJ19238_0120 {

    static int n, m, fuel;
    static int[][] board;
    static int taxiX, taxiY;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static List<int[]> passengers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 문제의 input을 받습니다.
        n = sc.nextInt();
        m = sc.nextInt();
        fuel = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) board[i][j] = -1; // 벽 표시
            }
        }

        taxiX = sc.nextInt() - 1;
        taxiY = sc.nextInt() - 1;

        passengers.add(new int[]{0, 0}); // 더미 값
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            int d = sc.nextInt() - 1;
            board[a][b] = i + 1;
            passengers.add(new int[]{c, d});
        }

        boolean flag = true;
        for (int i = 0; i < m; i++) {
            // 6-1. 가장 가까운 승객 찾기
            int[] result = findShortestPassenger(taxiX, taxiY);
            int dist = result[0];
            int startX = result[1];
            int startY = result[2];
            int destX = result[3];
            int destY = result[4];

            if (dist == -1) {
                flag = false;
                break;
            }

            // 6-2. 승객 목적지로 이동
            if (!movePassenger(startX, startY, destX, destY, dist)) {
                flag = false;
                break;
            } else {
                taxiX = destX;
                taxiY = destY;
            }
        }

        // 7. 결과 출력
        System.out.println(flag ? fuel : -1);
    }

    static int[] findShortestPassenger(int x, int y) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;
        List<int[]> candidates = new ArrayList<>();

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int dist = current[2];

            if (board[cx][cy] >= 1) {
                candidates.add(new int[]{cx, cy, dist});
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] != -1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist + 1});
                }
            }
        }

        if (candidates.isEmpty()) return new int[]{-1, -1, -1, -1, -1};

        candidates.sort((a, b) -> {
            if (a[2] != b[2]) return a[2] - b[2]; // 거리
            if (a[0] != b[0]) return a[0] - b[0]; // 행
            return a[1] - b[1]; // 열
        });

        int px = candidates.get(0)[0];
        int py = candidates.get(0)[1];
        int dist = candidates.get(0)[2];
        int passengerNum = board[px][py];
        return new int[]{dist, px, py, passengers.get(passengerNum)[0], passengers.get(passengerNum)[1]};
    }

    static boolean movePassenger(int startX, int startY, int destX, int destY, int getDist) {
        fuel -= getDist;
        if (fuel < 0) return false;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int dist = current[2];

            if (cx == destX && cy == destY) {
                if (fuel - dist >= 0) {
                    fuel -= dist;
                    fuel += (dist * 2);
                    board[startX][startY] = 0;
                    return true;
                } else {
                    return false;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] != -1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist + 1});
                }
            }
        }

        return false;
    }
}
