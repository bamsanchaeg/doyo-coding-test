package doyoCodingtest;

import java.io.*;
import java.util.*;

//1111개에서 9999개 까지니까 10000개의 배열 형성

public class P2659_0906_2 {

    static int[] numbers = new int[4];

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i =0; i<4; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int top = numbers[0]; //위쪽
        int right = numbers[1];//오른쪽
        int bottom = numbers[2];//아래쪽
        int left = numbers[3];//왼쪽


        //입력된 숫자의 시계수
        int ClockWiserNumber = generateClockwiseNumber(top,right,bottom,left);
        boolean[] visited = getClockNum();

        int answer = 0;
        for(int i =1111; i<=ClockWiserNumber; i++){
            if(visited[i]){
                answer++;
            }
        }

        System.out.println(answer);

    }

    public static boolean[] getClockNum(){
        boolean[] visit = new boolean[10000];

        for(int a=1; a<10; a++){
            for(int b=1; b<10; b++){
                for(int c=1; c<10; c++){
                    for(int d=1; d<10; d++){
                        int n = generateClockwiseNumber(a,b,c,d);
                        if(!visit[n]){
                            visit[n] = true;
                        }
                    }
                }
            }
        }

        return visit;
    }






    //시계방향으로 여러 시작점에서 4자리수를 생성하고, 가장 작은 수를 출력해야함.
    public static int generateClockwiseNumber(int top, int right, int bottom, int left){



        int[] intDirection = new int[4];

        intDirection[0] = top * 1000 + right * 100 + bottom * 10 + left;
        intDirection[1] = right * 1000 + bottom * 100 + left * 10 + top;
        intDirection[2] = bottom * 1000 + left * 100 + top * 10 + right;
        intDirection[3] = left * 1000 + top * 100 + right * 10 + bottom;

         return Arrays.stream(intDirection).min().orElse(-1);
    }


}
