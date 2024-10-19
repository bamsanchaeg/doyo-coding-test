package doyoCodingtest;

import java.io.*;
import java.util.*;

public class BOJ16937_0909 {

    /**
     * https://www.acmicpc.net/problem/16937
     * title : 두 스티커
     *
     * 1. 문제 요약
     * - H * W 공간에 N개의 사각스티커중 2개를 골라서 붙인다
     * - 스티커는 겹칠 수 없고 H * W 공간을 넘어가서는 안된다
     * - 스티커를 회전하는 것은 가능하다.
     * - 스티커 2개를 붙일 수 없으면 0, 있다면 최대 스티커 넓이를 출력
     *
     * 2. 문제 풀이
     * - 최대 H * W는 100 * 100 이다
     * - 스티커를 어떻게 붙이던 중요하진않고 붙일 수 있냐 없냐만 중요하다
     * - 스티커는 겹칠 수 없으므로 스티커 넓이 연산은 R * C 로 가능하다
     * - MAX_AREA = Max(Ri * Ci + Rj * Cj)
     *
     * - 스티커를 붙일 수 있는지 판단은 두 스티커를 수평으로 붙여보고 수직으로 붙여보면된다.
     * - 모든 스티커는 회전 할 수 있다는 것을 가정해야한다
     * - 마지막으로 스티커를 90도 회전시키는 것도 고려해야 한다.
     * - 이는 스티커의 가로와 세로를 서로 바꾸는 방식으로 구현할 수 있다
     */

    // N의 크기가 작기 때문에 완전탐색이 가능하다고 한다.
    static int maxSize;
    static int H,W,N;
    static int[][] stickers;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 모눈종이의 크기 입력
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        if (st.countTokens() < 2) {
            throw new IllegalArgumentException("모눈종이의 크기 입력이 잘못되었습니다.");
        };

        H = Integer.parseInt(st.nextToken());//종이의 높이
        W = Integer.parseInt(st.nextToken());//종이의 넓이
        N = Integer.parseInt(br.readLine());//스티커 갯수
        stickers = new int[N][2]; //스티커 정보를 저장할 배열

        //스티커 정보 입력
        for(int i =0; i<N ; i++){
            // 한 줄씩 입력받기
            line = br.readLine();

            // 공백을 기준으로 토큰 분리
            st = new StringTokenizer(line);

            // 각 스티커의 높이와 너비 입력
            if (st.hasMoreTokens()) {
                int r = Integer.parseInt(st.nextToken()); // 스티커의 높이
                int c = Integer.parseInt(st.nextToken()); // 스티커의 너비

                // 스티커 정보를 배열에 저장
                stickers[i][0] = r;
                stickers[i][1] = c;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                i--; // 잘못된 입력이 들어오면 다시 입력받을 수 있도록
            }
        }

        //두개의 스티커를 선택해서 최대 넓이 구하기
        maxSize=0;
        for(int i =0; i<N; i++){
            for(int j= i+1; j < N; j++){
                calculateMaxAreas(stickers[i][0], stickers[i][1], stickers[j][0], stickers[j][1]);
            }
        }

        System.out.println(maxSize);


    }
    public static void calculateMaxAreas(int r1, int c1, int r2, int c2){
        int[][] rotations = {
                {r1,c1},{c1,r1},
                {r2,c2},{c2,r2}
        };

        // 모든 스티커의 회전 조합을 테스트
        for(int i=0; i<2; i++){
            for(int j=2; j<4; j++){
                // 스티커를 나란히 배치
                if(rotations[i][0] + rotations[j][0] <= H && Math.max(rotations[i][1], rotations[j][1]) <= W){
                    maxSize = Math.max(maxSize, rotations[i][0]*rotations[i][1] + rotations[j][0]*rotations[j][1]);
                }
                // 스티커를 위아래로 배치
                if(Math.max(rotations[i][0], rotations[j][0]) <= H && rotations[i][1] + rotations[j][1]<=W){
                    maxSize = Math.max(maxSize, rotations[i][0] * rotations[i][1] + rotations[j][0] * rotations[j][1]);
                }
            }

        }

    }

}
