package doyoCodingtest.DoyoBaekJoon.test2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10157_0917 {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int C = Integer.parseInt(st.nextToken());//열의 개수
        int R = Integer.parseInt(st.nextToken());//행의 개수
        int K = Integer.parseInt(br.readLine());

        int[][] grid = new int[C][R];

        //초기 위치와 방향(왼쪽 아래에서 시작)
        int x = 0, y = 0;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};  // 위, 오른쪽, 아래, 왼쪽

        int dir = 0;//처음에는 위쪽으로 이동
        int num = 1;

        //찾고자 하는 좌표를 저장할 변수
        int targetX = -1, targetY = -1;


        while(num <= C*R){

            grid[x][y] = num;

            if(num == K){
                targetX = x+1;
                targetY = y+1;
            }

            num++;

            //다음 좌표 계산(방향은 고정되어있는 상태)
            int nx = x + directions[dir][0];
            int ny = y + directions[dir][1];

            //격자를 벗어나거나 이미 채워진 경우 방향 전환
            if(nx < 0 || nx >= C || ny < 0 || ny >= R || grid[nx][ny] != 0){
               //이 4개의 방향을 순서대로 따르다가 더 이상 이동할 수 없을 때, dir = (dir + 1) % 4를 사용하여 다음 방향으로 전환한다.
                // 상 -> 우 -> 하 -> 좌
                // 하지만 배열의 좌표가
                dir = (dir + 1) % 4;  // 방향을 전환
                nx = x + directions[dir][0];//x축으로 이동(첫번째)
                ny = y + directions[dir][1];//y축으로 이동(2번째)
            }

            //다음 위치로 이동
            x = nx;
            y = ny;
        }


        if(targetX != -1 && targetY != -1){
            //실제 배열에 출력된 숫자의 반대 방향이기 때문에 X와 Y축의 위치를 바꿔준다.
            System.out.println( targetX + " " + (targetY));
        }else{
            System.out.println("0");
        }


        br.close();


    }
}
