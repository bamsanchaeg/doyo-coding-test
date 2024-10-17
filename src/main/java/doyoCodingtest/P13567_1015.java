package doyoCodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P13567_1015 {
    //로봇이 이동할 수 있는 영역의 크기 M
    static int M,N;
    static int[][] range;
    static String[][] orders;

    //로봇의 현재 위치와 방향
    static int x = 0;
    static int y = 0;
    static int dir = 1;
    private static final int[] DR = {1, 0, -1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());


        //로봇 명령어 처리
       while (N --> 0){
           st = new StringTokenizer(br.readLine());
           String command = st.nextToken();
           if(command.charAt(0) == 'T'){//Turn 명령어
               char turnDirection = st.nextToken().charAt(0);
               //방향전환
               dir += (turnDirection == '0') ? -1 : 1; // 왼쪽(0) 또는 오른쪽(1) 회전
               if (dir < 0) dir = 3; // 방향 범위 조정
               if (dir > 3) dir = 0; // 방향 범위 조정
           }else{ // MOVE 명령어
               int dist = Integer.parseInt(st.nextToken());//거리
               x += DR[dir] * dist; // x좌표 업데이트
               y += DC[dir] * dist;

               //유효성 검사
               if(x>=M || y >=M || x<0 || y<0){
                   System.out.println(-1);
                   return;
               }
           }
       }


        System.out.println( y+ " " +  x);


    }




}
