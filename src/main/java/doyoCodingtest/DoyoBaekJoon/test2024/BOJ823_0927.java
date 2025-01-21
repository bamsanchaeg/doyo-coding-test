package doyoCodingtest.DoyoBaekJoon.test2024;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2823_0927 {

    static int R, C;
    static char[][] board;
    static int[] dx = {0,0,1,-1};//가로측 이동(오른쪽, 왼쪽)
    static int [] dy = {1,-1,0,0};//세로축 이동(위,아래)
    static boolean[][] visited;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        //1.문제의 input을 받는다. 3 ≤ R, C ≤ 10
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        board = new char[R][C];
        visited = new boolean[R][C]; //배열 초기화를 해야 NullPointException이 발생하지 않는다.
        //정보 기입
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        if(checkBlockedPaths()){
            System.out.println(1);
        }
        if(!checkBlockedPaths()){
            System.out.println(0);
        }

    }

    static boolean checkBlockedPaths(){
        //2중 for 루프를 통해 마을의 각 좌표 (i, j)에 대해 이동 가능한 경로를 확인한다.
        for(int i = 0; i < R; i++){
            for(int j = 0; j<C; j++){
                //각 좌표에서 **도로(.)**에 대해서만 확인한다.
                if(board[i][j] == '.'){
                    int openPaths = 0;
                    //4방향 배열을 확인
                    for(int k = 0; k< 4; k++){
                        int nx = i + dx[k]; //현재 4방향 배열 중 . 값이 들어있는 정보값이 있는지
                        int ny = j + dy[k];

                        //범위를 벗어나지 않고 이동가능해야 한다.
                        if(nx >=0 && nx < R && ny>=0 && ny<C && board[nx][ny] == '.'){
                            openPaths++;
                        }
                    }

                    if (openPaths<=1){
                        return true; //유턴금지 조건 만족
                    }
                }
            }
        }

        //유턴 금지 조건 없음
        return false;
    }


}
