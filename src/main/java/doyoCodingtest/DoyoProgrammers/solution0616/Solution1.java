package doyoCodingtest.DoyoProgrammers.solution0616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 머쓱이네 피자가게는 피자를 일곱 조각으로 잘라 줍니다.
// 피자를 나눠먹을 사람의 수 n이 주어질 때,
// 모든 사람이 피자를 한 조각 이상 먹기 위해 필요한 피자의 수를
// return 하는 solution 함수를 완성해보세요.

// 7명보다 적은 값이 나왔을때 어떻게 접근해야하는지를 생각해야했던 문제,
// 나머지 수가 있는 경우를 1로 가정하여 배정하는 사고를 가져보자.

public class Solution1 {
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
       // String s = bf.readLine(); //String 입력시 사용할 것
        int i = Integer.parseInt(bf.readLine()); //Int 입력시 사용하는 것
        int answer = 0;
        if(i%7 == 0){
            answer = i/7;

        }else {
            answer = (i/7) + 1;
        }

        //프로그래머스에서 return값을 주지만 여기서는 String으로 값을 받기 때문에 이 식을 씁니다
        //참고참고!.
        System.out.println("우리에게 필요한 피자는" + answer);
    }

}
