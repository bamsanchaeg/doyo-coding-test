package doyoCodingtest.DoyoBaekJoon.test2024;

import java.io.*;
import java.util.*;

public class BOJ14247_0914 {

    //그리디 알고리즘 문제
    //나무들이 자라는 길이 * 나무의 갯수(날짜) + 현재 나무의 길이를 더해서 그 길이가 가장 짧은 순서인 애부터 잘라내야함.

    static int[][] treesInfo;
    static long answer = 0;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        treesInfo = new int[N][2]; //0은 현재 길이, 1은 자라는 속도

        //맨처음 나무 정보의 값과 나무가 자라는 속도 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            treesInfo[i][0] = Integer.parseInt(st.nextToken()); //현재 길이

        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            treesInfo[i][1] = Integer.parseInt(st.nextToken()); // 자라는 속도
        }

        Arrays.sort(treesInfo, new Comparator<int[]>() {
            @Override
            public int compare(int[] tree1, int[] tree2) {
                return tree1[1]-tree2[1];
            }
        });

        for(int day=0; day<N; day++){
            answer += treesInfo[day][0] + (long) treesInfo[day][1] *day;

        }
        System.out.println(answer);

    }

}
