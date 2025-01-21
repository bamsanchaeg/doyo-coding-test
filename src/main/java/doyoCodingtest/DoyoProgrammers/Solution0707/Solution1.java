package doyoCodingtest.DoyoProgrammers.Solution0707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 정수 배열 numbers와 정수 num1, num2가 매개변수로 주어질 때,
 numbers의 num1번 째 인덱스부터 num2번째 인덱스까지 자른 정수 배열을 return 하도록 solution 함수를 완성해보세요.
 **/
public class Solution1 {
    public static void main(String[] args) throws IOException {

        System.out.println("정수 배열과 매개변수를 차례차례 입력하세요");
        //입력 예시 [1, 2, 3, 4, 5]

        BufferedReader numbers = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader numbers1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader numbers2 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("배열 안 숫자를 입력하시오");

        // 사용자로부터 3개의 정수를 입력받아 배열에 저장
        // 배열의 갯수는 다섯개로 한정했는데, 문제 의도와 맞는건진 잘 모르겠다.
        /** 이런 배열 선언도 가능하다.
         int[] allStudentHeights = {170, 180, 165, 175, 168};
         int height = 170;
         int answer = 0;
         **/

        int[] number = new int[]{
                Integer.parseInt(numbers.readLine()),
                Integer.parseInt(numbers.readLine()),
                Integer.parseInt(numbers.readLine()),
                Integer.parseInt(numbers.readLine()),
                Integer.parseInt(numbers.readLine())
        };

        int num1 = Integer.parseInt(numbers1.readLine());
        int num2 = Integer.parseInt(numbers2.readLine());

        //배열을 어떻게 넣을지 고민은 해봐야하는데.. 일단 for 문에서 answer 의 배열 길이를 설정할때는 num1을 뺀 뒤 1을 넣어야 할 것 같다.
        int[] answer = new int[num2 - num1 + 1];
        int index = 0;

        for(int i = num1; i <= num2; i++) {
            answer[index++] = number[i];
        }

        System.out.println("잘린 배열의 크기" + answer);
    }
}
