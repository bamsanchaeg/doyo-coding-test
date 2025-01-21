package doyoCodingtest.DoyoProgrammers.Solution0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 영어에선 a, e, i, o, u 다섯 가지 알파벳을 모음으로 분류합니다.
 * 문자열 my_string이 매개변수로 주어질 때 모음을 제거한 문자열을 return하도록 solution 함수를 완성해주세요.
 * **/

public class Solution2 {

    public static void main(String[] args) throws IOException {

        //여기서 replaceAll은 해당 문자에 해당하는 문자열을 ""로 바꿔준다는 의미이다.
        String sentence = my_string().replaceAll("[aeiouAEIOU]","");
        System.out.println("모음이 제거된 문자열은 " + sentence + "입니다.");
    }

    public static String my_string() throws IOException {
        System.out.println("단어를 입력하세요");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }


}
