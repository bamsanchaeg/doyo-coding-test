package doyoCodingtest.DoyoProgrammers.Solution0707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//정수 배열 numbers가 매개변수로 주어집니다.
//numbers의 각 원소에 두배한 원소를 가진 배열을 return하도록 solution 함수를 완성해주세요.

public class Solution3 {
    public static void main(String[] args) throws IOException {

        System.out.println("배열의 자리수는 5자리수입니다. 안의 배열값을 입력해주세요.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //배열 안의 값 선언
        int[] number = new int[]{
                Integer.parseInt(reader.readLine()),
                Integer.parseInt(reader.readLine()),
                Integer.parseInt(reader.readLine()),
                Integer.parseInt(reader.readLine()),
                Integer.parseInt(reader.readLine())
        };

        int[] answer = new int[number.length];

        for(int i = 0; i < number.length; i++){
            answer[i] = number[i] * 2;
        }

        //Arrays.toString(answer): 이 메서드는 Java의 Arrays 클래스에 속하며 배열을 문자열 표현으로 변환하는 데 사용됩니다.
        //배열을 인수로 받아 쉼표로 구분된 배열 요소를 포함하는 문자열을 반환합니다
        System.out.println("배열의 리턴값은" + Arrays.toString(answer));

    }
}
