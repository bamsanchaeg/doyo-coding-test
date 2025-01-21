package doyoCodingtest.DoyoProgrammers.solution0623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {
    public static void main(String[] args) throws IOException {

        /**
         가위는 2 바위는 0 보는 5로 표현합니다.
         가위 바위 보를 내는 순서대로 나타낸 문자열 input이 매개변수로 주어질 때,
         input에 저장된 가위 바위 보를 모두 이기는 경우를 순서대로 나타낸 문자열을 return하도록 solution 함수를 완성해보세요.
         **/
        System.out.print("가위바위보의 숫자를 입력하세요 :");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String 입력식이라 Parse를 쓸 필요는 없다.
        String input = reader.readLine();
        //새로운 스트링 선언방법은 이렇게 하면 될 것 같다.
        String answer = "";

        //입력된 String answer를 쪼개주는 API
        String[] arr = input.split("");

        //향상된 For 문 볼때마다 너무 신기함. 다음엔 보지않고 기입해보기.
        for (String s : arr) {
            switch (s) {
                case "2" -> answer += 0;
                case "0" -> answer += 5;
                case "5" -> answer += 2;
            }
        }

        System.out.println("이길 수 있는 가위바위보의 수는 '" + answer + "' 입니다.");
    }

}
