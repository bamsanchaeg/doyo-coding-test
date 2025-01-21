package doyoCodingtest.DoyoProgrammers.Solution0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//문자열 my_string이 매개변수로 주어질 때,
//대문자는 소문자로 소문자는 대문자로 변환한 문자열을 return하도록 solution 함수를 완성해주세요.

/**
 타인의 풀이(3항 연산자 쓰는거 진짜 어떻게 하는걸까? 너무 신기함)
 변수 이름 잘 지어주기.

 class Solution {
 public String solution(String myString) {
 return myString.chars().mapToObj(operand -> String.valueOf((char) (Character.isLowerCase(operand) ? Character.toUpperCase(operand) : Character.toLowerCase(operand)))).collect(Collectors.joining());
 }
 }
 **/
public class Solution1 {
    public static void main(String[] args) throws IOException {
        System.out.println("문자열을 입력하세요");
        BufferedReader alphabetReader = new BufferedReader(new InputStreamReader(System.in));
        String alphabet = alphabetReader.readLine();
        StringBuilder answer = new StringBuilder();

        for(int i=0;i<alphabet.length();i++){
            char c = alphabet.charAt(i);
            if(Character.isUpperCase(c)){
                answer.append(Character.toLowerCase(c));
            }else{
               answer.append(Character.toUpperCase(c));
            }
        }

        System.out.println(answer);
    }
}
