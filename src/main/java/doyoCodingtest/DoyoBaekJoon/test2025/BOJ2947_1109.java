package doyoCodingtest.DoyoBaekJoon.test2025;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2947_1109 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        // 원하는 순서가 될 때까지 반복
        while (true) {
            boolean sorted = true;
            for (int j = 0; j < numbers.size() - 1; j++) {
                if (numbers.get(j) > numbers.get(j + 1)) {
                    // 두 숫자를 교환
                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);

                    // 교환 후 리스트 상태 출력
                    for (int num : numbers) {
                        bw.write(num + " ");
                    }
                    bw.newLine();

                    sorted = false; // 정렬이 완료되지 않았음을 표시
                }
            }
            // 리스트가 정렬된 상태면 반복 종료
            if (sorted) break;
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
