package doyoCodingtest.DoyoBaekJoon.bojTemp;

//gitignore

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182_0910 {

    static int N,S;
    static int[] numOfNumbers;
    static int count = 0;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수열의 길이
        S = Integer.parseInt(st.nextToken()); // 목표 합

        numOfNumbers = new int[N];

        //정수의 갯수 입력받기
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            numOfNumbers[i] = Integer.parseInt(st.nextToken());
        }

        // DFS 탐색 시작 (0번째 인덱스부터 시작)
        // S가 0일 경우 아무런 원소를 선택하지 않는 경우가 포함되므로 1 감소가 필요함.
        calculateNum(0, 0);
        if(S == 0){
            count--; //공집합 제외
        }

        System.out.println(count);

    }

    //dfs 탐색
    public static void calculateNum(int index, int sum){
        
        if(index == N){
            if(sum == S){
                count++;
            }
            return;
        }

        calculateNum(index+1,sum); //현재 원소를 포함하지 않는 경우
        calculateNum(index+1,sum + numOfNumbers[index]); // 현재 원소를 포함하는 경우

    }
}
