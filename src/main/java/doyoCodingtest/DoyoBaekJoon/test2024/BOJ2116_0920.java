package doyoCodingtest.DoyoBaekJoon.test2024;

import java.io.*;
import java.util.*;

public class BOJ2116_0920 {
    static int [][] dices;
    static int N, Max;
    static int[] dimension = {5,3,4,1,2,0};//각 마주보는 면의 인덱스를 저장
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        dices = new int[N][6];


        for(int i =0; i< N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<6; j++){
                dices [i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Max = -1;
        //윗 면 정하기
        for(int i=0; i<6; i++){
            int max = 0;
            for(int j=0; j<6; j++){
                if(j ==i || j == dimension[i]) continue;
                max = Math.max(max,dices[0][j]);
            }
            stackDice(dices[0][i],max,1);//윗면의 값과 옆면 중에서 가장 큰 값
        }

        System.out.println(Max);

    }

    private static void stackDice(int top,int sum, int count){
        if(count ==N){
            Max = Math.max(sum, Max);
            return;
        }
        //현재 주사위에서 top에 해당하는 인덱스를 찾아야함
        int idx = 0;
        for(int i=0; i<6; i++){
            if(dices[count][i] == top){
                idx=i;
                break;
            }
        }
        int nextTop = dimension[idx]; // 현재 주사위의 윗면의 인덱스 결정
        int m = 0;
        for(int j=0; j<6; j++){
            if(j== nextTop || j == idx) continue;
            m = Math.max(m,dices[count][j]);
        }
        stackDice(dices[count][nextTop], sum + m, count +1);
    }
}
