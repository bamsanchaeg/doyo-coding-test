package doyoCodingtest.DoyoBaekJoon.test2024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BOJ2303_1122 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> players = new ArrayList<>();

        for(int i = 0; i<n; i++){
            String[] input = br.readLine().split(" ");
            List<Integer> cards = new ArrayList<>();
            for(String card : input){
                cards.add(Integer.parseInt(card));
            }
            players.add(cards);
        }

        // 각 플레이어의 최대 일의 자리 수 계산
        int maxUnitsDigit = -1;
        int winner = -1;
        for(int i = 0; i<n; i++){
            List<Integer> cards = players.get(i);
            int maxDigitForPlayer = 0;

            for(int a =0; a<cards.size(); a++){
                for(int b = a+1; b<cards.size(); b++){
                    for(int c = b+1; c <cards.size(); c++){
                        int sum = cards.get(a) + cards.get(b) + cards.get(c);
                        int digit = sum % 10;
                        maxDigitForPlayer = Math.max(maxDigitForPlayer, digit);
                    }
                }
            }

            // 가장 큰 일의 자리 수 갱신 및 승자 확인
            if (maxDigitForPlayer >= maxUnitsDigit) {
                maxUnitsDigit = maxDigitForPlayer;
                winner = i + 1; // 플레이어 번호는 1부터 시작
            }
        }

        bw.write(winner + "\n");
        bw.flush();

        br.close();
        bw.close();

    }
}
