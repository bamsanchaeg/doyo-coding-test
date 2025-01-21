package doyoCodingtest.DoyoBaekJoon.test2025;

import java.util.*;
import java.io.*;

public class BOJ2805_1021 {
    static int N,M;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];

       st = new StringTokenizer(br.readLine(), " ");

        //나무 높이 입력
        int maxTreeHeight = 0;
        for(int i = 0; i<N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            maxTreeHeight = Math.max(maxTreeHeight,trees[i]);
        }


        bw.write(cuttingTrees(maxTreeHeight, trees) + "\n");
        bw.flush(); // 버퍼 비우기
        br.close();
        bw.close();



    }

    private static int cuttingTrees(int maxTreeHeight, int[] trees){
        int left = 0; //최소 높이
        int result = 0;

        while (left <= maxTreeHeight){
            int mid = (left + maxTreeHeight)/2; //중간 높이
            long total = 0; //잘린 나무의 총 길이

            for(int tree : trees){
                if(tree > mid){
                    total += tree - mid;
                }
            }

            //얻은 나무가 M 이상이면 높이를 더 높여본다
            if(total >= M){
                result = mid; //가능한 최대 높이 갱신
                left = mid + 1;
            }else{
                //얻은 나무가 M보다 적으면 높이를 낮춘다
                maxTreeHeight = mid -1;
            }
        }

        return result;

    }
}
