package doyoCodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2615_1017 {
    static final int size = 19;
    static final int[][] directions = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};  // 방향 배열: 가로, 세로, ↘, ↗

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[size][size];  // 바둑판 19x19 배열

        // 바둑판 입력 받기
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < size; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 승리자 탐색
        Result result = findWinner(board);
        if (result.winner == 0) {
            System.out.println(0);  // 승부가 결정되지 않음
        } else {
            System.out.println(result.winner);
            System.out.println(result.x + " " + result.y);  // 승리자의 좌표 출력 (1-based 좌표)
        }
    }

    // 승리자를 찾는 함수 (좌표도 함께 반환)
    public static Result findWinner(int[][] board) {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (board[x][y] != 0) {  // 돌이 있는 경우에만 탐색
                    int color = board[x][y];

                    // 네 방향 탐색
                    for (int[] direction : directions) {
                        if (checkDirection(board, x, y, direction[0], direction[1], color)) {
                            return new Result(color, x + 1, y + 1);  // 승리자와 좌표 반환 (1-based 좌표)
                        }
                    }
                }
            }
        }
        return new Result(0, 0, 0);  // 승부가 결정되지 않음
    }

    // 한 방향으로 5개의 연속된 돌이 있는지 확인하는 함수
    public static boolean checkDirection(int[][] board, int x, int y, int dx, int dy, int color) {
        int count = 1;  // 현재 돌 포함, 1로 설정
        int nx = x + dx;
        int ny = y + dy;

        // 5개의 돌이 연속으로 있는지 확인
        while (isInBounds(nx, ny) && board[nx][ny] == color) {
            count++;
            if (count > 5) return false;  // 6개 이상의 돌이 연결되면 승리 아님
            nx += dx;
            ny += dy;
        }

        // 정확히 5개의 돌이 연결되었을 때
        if (count == 5) {
            // 앞쪽이 같은 색 돌이 아닌지 확인
            int prevX = x - dx;
            int prevY = y - dy;
            if (isInBounds(prevX, prevY) && board[prevX][prevY] == color) return false;

            // 뒤쪽이 같은 색 돌이 아닌지 확인
            if (isInBounds(nx, ny) && board[nx][ny] == color) return false;

            return true;  // 정확히 5개의 돌이 연속된 경우
        }
        return false;
    }

    // 좌표가 바둑판 범위 내에 있는지 확인하는 함수
    public static boolean isInBounds(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }
}

// 승리자를 저장하기 위한 클래스
class Result {
    int winner;  // 1: 검은색 승리, 2: 흰색 승리
    int x, y;    // 승리한 바둑알 중 가장 왼쪽 또는 가장 위쪽의 좌표

    public Result(int winner, int x, int y) {
        this.winner = winner;
        this.x = x;
        this.y = y;
    }
}
