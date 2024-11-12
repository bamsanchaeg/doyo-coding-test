package doyoCodingtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7568_1112 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] people = new int[n][2];
        int[] ranks = new int[n];
        Arrays.fill(ranks, 1);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //j번째 사람의 몸무게와 키가 모두 i번째 사람보다 크면, j번째 사람은 i번째 사람보다 “더 우위에 있다”고 판단할 수 있다.
                if (people[j][0] > people[i][0] && people[j][1] > people[i][1]) {
                    //위 조건을 만족하는 경우, ranks[i]++가 실행되어 i번째 사람의 등수가 1 증가합니다.
                    ranks[i]++;
                }
            }
        }


        // 결과를 BufferedWriter로 출력
        for (int i = 0; i < n; i++) {
            bw.write(ranks[i] + " ");
        }

        // 버퍼에 담긴 내용을 출력하고 BufferedWriter를 닫음
        bw.flush();

    }
}
