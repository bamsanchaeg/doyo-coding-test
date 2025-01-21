package doyoCodingtest.DoyoBaekJoon.test2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2204_12010 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            List<String> words = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                words.add(br.readLine());
            }

            //정렬, 대소문자 무시
            words.sort((a,b) -> a.toLowerCase().compareTo(b.toLowerCase()));

            //가장 앞서는 단어 출력
            System.out.println(words.get(0));

        }

    }
}
