package doyoCodingtest.DoyoBaekJoon.test2025;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2578_1112 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] board = new int[5][5];
        int[][] numbers = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        boolean bingo = false;

        OuterLoop:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                count++;
                int number = numbers[i][j];

                //빙고판에서 숫자를 찾아서 -1로 마감
                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 5; y++) {
                        if (board[x][y] == number) {
                            board[x][y] = -1;
                        }
                    }
                }

                // 빙고 체크 (가로, 세로, 대각선)
                int bingoCount = 0;

                //가로줄 체크
                for (int x = 0; x < 5; x++) {
                    boolean isBingo = true;
                    for (int y = 0; y < 5; y++) {
                        if (board[x][y] != -1) {
                            isBingo = false;
                            break;
                        }
                    }
                    if (isBingo) {
                        bingoCount++;
                    }
                }

                //세로줄 체크
                for (int y = 0; y < 5; y++) {
                    boolean isBingo = true;
                    for (int x = 0; x < 5; x++) {
                        if (board[x][y] != -1) {
                            isBingo = false;
                            break;
                        }
                    }
                    if (isBingo) {
                        bingoCount++;
                    }
                }

                //대각선 체크(왼쪽 위에서 오른쪽 아래)
                boolean isBingo = true;
                for (int x = 0; x < 5; x++) {
                    if (board[x][x] != -1) {
                        isBingo = false;
                        break;
                    }
                }
                if (isBingo) {
                    bingoCount++;
                }

                //반대 대각선 체크
                isBingo = true;
                for (int x = 0; x < 5; x++) {
                    if (board[x][4 - x] != -1) {
                        isBingo = false;
                        break;
                    }
                }
                if (isBingo) {
                    bingoCount++;
                }

                if (bingoCount >= 3) {
                    bw.write(count + "\n");
                    bingo = true;
                    break OuterLoop;
                }
            }
        }
        bw.flush();
        bw.close();
    }

}
