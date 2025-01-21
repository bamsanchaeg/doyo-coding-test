package doyoCodingtest.DoyoBaekJoon.test2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ25305_1108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫 번째 줄에서 N과 k 값을 동시에 읽기
        StringTokenizer nk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(nk.nextToken());
        int k = Integer.parseInt(nk.nextToken());
        List<Integer> x = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            x.add(Integer.parseInt(st.nextToken()));
        }

        x.sort(Collections.reverseOrder());

        // 커트라인 점수 구하기
        int cutoffScore = x.get(k - 1);
        System.out.println(cutoffScore);


    }

}
