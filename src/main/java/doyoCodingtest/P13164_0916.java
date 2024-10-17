package doyoCodingtest;

import java.io.*;
import java.util.*;

public class P13164_0916 {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

       //배열에 정보값을 넣어주기
        int [] child = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            child[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(minimizeCost(child,K));
    }

    public static int minimizeCost(int[] child,int K){

        int length = child.length;

        //인원수대로 그룹을 나눌 수 있을때는 0 리턴
        if( K == length){
            return 0;
        }

        //전체 최소값과 최대값 차이(전체를 하나의 그룹으로 묶었을때 비용)
        int totalCost = child[length-1] - child[0];

        //인접 원소 간 차이를 계산(맨 뒷자리는 필요없으니 -1을 해준다)
        int[] diffs = new int[length-1];
        for(int i=0; i<length -1; i++){
            //오름차순으로 정리되어있으니 인접한 숫자들의 차를 배열에 넣어준다
            diffs[i] = child[i+1] - child[i];
        }

        //차이가 작은 순서대로 정렬
        Arrays.sort(diffs);

        //전체 배열의 비용
        //왜 K-1개의 차이를 제거하는가?:
        //배열을 N개의 그룹으로 나누기 위해서는 N-1개의 구간에서 그룹을 나누어야 한다(케이크 세조각을 먹기 위해서 칼질 두번을 하는 것처럼)
        //그러니 우리는 케이크를 나누는 것 처럼 그룹을 나누는 횟수에 맞춰 차이가 가장 큰 숫자들을 제거하는 것이다.
        //length 에서 -2를 하는 이유는 diffs는 인접한 숫자간의 차이를 구하는 것이기 때문에 기본 길이가 length -1 이다.
        //그리고 마지막 숫자는 우리가 이미 구한 totalCost이기 때문에 제외하여 diffs[length-2 -i];가 된다.
        //
        //숫자 차이가 큰 것을 기준으로 두어 집합을 나누면 전체 비용이 최소화된다.
        for(int i=0; i< (K-1); i++){
            totalCost -= diffs[length-2 -i];//가장 큰 차이부터 제거, 인덱스 범위 주의
        }


        return totalCost;

    }
}
