package doyoCodingtest.DoyoProgrammers.solution0616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 배열문제가 많이 헷갈려서 이 부분에 대해서 숙지가 잘 되어야 할듯
// 머쓱이는 추운 날에도 아이스 아메리카노만 마십니다.
// 아이스 아메리카노는 한잔에 5,500원입니다.
// 머쓱이가 가지고 있는 돈 money가 매개변수로 주어질 때,
// 머쓱이가 최대로 마실 수 있는 아메리카노의 잔 수와 남는 돈을 순서대로 담은 배열을 return 하도록
// solution 함수를 완성해보세요.

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(bf.readLine());

        int[] answer = new int[2];

        if(money<5500){
            answer[0] = 0;
            answer[1] = money;

        }else {

            answer[0] = money/5500;
            answer[1] = money%5500;

        }

        System.out.println("아메리카노" + answer[0] + "잔 드립니다");
        System.out.println("잔돈은" + answer[1] + "원 드립니다");

    }
}
