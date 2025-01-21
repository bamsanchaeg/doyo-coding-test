package doyoCodingtest.DoyoProgrammers.Solution0630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//isDigit 함수는 명시된 char의 값이 숫자인지 여부를 판단하여 true or false 값으로 리턴한다.
//siLetter과 반대 기능을 한다고 생각하면 된다.

/**
 문자열 my_string이 매개변수로 주어집니다.
 my_string안의 모든 자연수들의 합을 return하도록 solution 함수를 완성해주세요.

 **/

public class Solution2 {

    public static void main(String[] args) throws IOException {
        System.out.println("MyString의 입력값이 주어집니다");
        BufferedReader my_String =  new BufferedReader(new InputStreamReader(System.in));
        String input = my_String.readLine();
        int answer = 0;

        for(int i = 0 ; i < input.length() ; i++){
            //charAt() 메서드는 String 객체 s 에서 i번째 문자를 추출하여 char 변수 c 에 할당하는 데 사용된다.
            char ch = input.charAt(i);
            if(Character.isDigit(ch)){
                answer += Integer.parseInt(String.valueOf(ch));
            }
        }
        System.out.println("문자열에 들어간 숫자의 합은 : " + answer);
    }
}
