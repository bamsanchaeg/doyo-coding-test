package doyoCodingtest.DoyoBaekJoon.bojTemp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BOJ2012_0925 {

    static int[] expectedGrades;
    static int N;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        expectedGrades = new int[N];

        //예상 등수 입력
        for(int i= 0 ; i < N; i++){
            expectedGrades[i] = Integer.parseInt(br.readLine());
        }

        //예상 등수 정렬
        Arrays.sort(expectedGrades);

        //overflow의 크기 넘침 방지
        long totalDissatisfaction = 0;

        //등수 차와 절대값 빼기
        for(int i = 0; i< N; i++){
            int actualRank = i + 1;
            totalDissatisfaction += Math.abs(expectedGrades[i] - actualRank);
        }

        System.out.println(totalDissatisfaction);

    }
}
