package doyoCodingtest.DoyoProgrammers.solution0623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// BufferedReader를 사용하기 위해서는 throws IOException을 해 주어야 함.
public class Solution2 {
    public static void main(String[] args) throws IOException {
        //정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요.
        System.out.println("숫자를 입력하세요 : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력받은 정수
        int n = Integer.parseInt(br.readLine());

        /**
         이 문제는 배열이 홀수 카운트 만큼 선언되어야 한다는 점이라,
         이 부분을 해결하기 위해 노력을 많이 함.
         삼항연산자 if - then - else 의 방법.. 오늘 다시 알게됨**/
        int oddCount = n % 2 == 0 ? n / 2 : n / 2 + 1;

        //answer부분의 배열 넘버를 입력된 숫자의 홀수 카운트 만큼 입력함.
        int[] answer = new int[oddCount];



        /**
         숫자를 하나하나 증가시켜 홀수 카운팅한 배열의 숫자만큼 for문을 돌리고, 배열에 이 홀수를 선언해준다.

         answer[i] = 2 * i + 1;:  루프 안에서 대입 문 answer[i] = 2 * i + 1; 이 실행됩니다.
         이 문장은 answer 배열의 i번째 요소에 값을 할당합니다.
         answer[i]: 이는 answer 배열의 i번째 요소를 나타냅니다.
         배열은 0부터 인덱싱되므로 answer[0]은 첫 번째 요소, answer[1]은 두 번째 요소를 나타냅니다.
         2 * i + 1: 이 식은 answer 배열에 저장할 홀수를 계산합니다.현재 반복 번호 i를 2로 곱하고 1을 더합니다.
         예를 들어 i가 0일 때 식은 1 (2 * 0 + 1)로 계산되고, i가 1일 때는 3 (2 * 1 + 1)으로 계산됩니다.
         (if i%2 != 0 대신 이 값을 쓴 것 같다.)
         **/

        for (int i = 0; i < oddCount; i++) {
            answer[i] = 2 * i + 1;

        }

        /**
         Arrays.toString(배열)
         지정된 배열 내용의 문자열 표현을 반환합니다.
         문자열 표현은 대괄호("[]")로 묶인 배열 요소 목록으로 구성됩니다.
         인접한 요소는 문자 ","(쉼표 다음에 공백)로 구분됩니다.
         배열중 일부 요소가 null인 경우 "null"을 반환합니다.
         **/

        System.out.println("주어진 수 까지의 홀수의 값:" + Arrays.toString(answer));
        //입력 스트림을 닫고 모든 자원을 해제하는 식, 중간에 쓰면 다 초기화 되니까 조심
        br.close();


    }
}
