package doyoCodingtest.DoyoBaekJoon.test2024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11663_1020 {

    static int N,M;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());//점의 개수
        M = Integer.parseInt(st.nextToken());//선분의 개수

        //두번째 줄에서 점들의 좌표 입력 받기
        int[] points = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            points[i] = Integer.parseInt(st.nextToken());
        }

        //점들을 오름차순으로 정렬
        Arrays.sort(points);

        //M개의 선분에 대해 처리
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            //이분 탐색을 통해 선분 [left, right] 범위에 속하는 점의 개수 계산
            int leftIndex = lowerBound(points, left);// left 이상의 첫 번째 인덱스
            int rightIndex = upperBound(points,right);// right 이하의 마지막 인덱스

            // 범위 내에 있는 점의 개수 계산
            int count = rightIndex - leftIndex;
            bw.write(count + "\n");
        }

        br.close();
        bw.close();

    }

    //1 이상의 첫 인덱스를 찾는 함수
    private static int lowerBound(int[] points,int value){
        int low = 0, high = points.length;
        while (low<high){
            int mid = (low + high) / 2;
            if(points[mid] < value){
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return low;
    }

    private static int upperBound(int[] points ,int value){
        int low = 0, high = points.length;
        while (low<high){
            int mid = (low + high)/2;
            if(points[mid] <= value){
                low = mid + 1;
            }else {
                high = mid;
            }
        }

        return low;
    }

}
