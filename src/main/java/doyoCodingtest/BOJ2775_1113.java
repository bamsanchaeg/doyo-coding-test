package doyoCodingtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2775_1113 {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());
        int[] results = new int[T];

        for(int t = 0; t<T; t++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            //apartment라는 2차원 배열을 생성한다. apartment[i][j]는 i층 j호에 사는 사람 수를 나타낸다
            int[][] apartment = new int[k+1][n+1];

            //0층 초기화
            for(int i = 1; i<=n; i++){
                apartment[0][i] = i;
            }

            //1층부터 k층까지 각 층에 대해 호수를 계산한다.
            //k층 n호에 사는 사람 수는 k층 (n-1)호와 k-1층 n호의 합이다
            //이 규칙을 이용해 모든 층과 호수의 값을 채워나간다.
            for(int floor = 1; floor <= k; floor++){
                for(int room = 1; room <= n; room++){
                    apartment[floor][room] = apartment[floor][room-1] + apartment[floor-1][room];
                }
            }

            results[t] = apartment[k][n];

        }

        //결과출력
        for(int result : results){
            bw.write(String.valueOf(result));
            bw.write(System.lineSeparator());
        }

        bw.flush();
        br.close();
        bw.close();

    }
}
