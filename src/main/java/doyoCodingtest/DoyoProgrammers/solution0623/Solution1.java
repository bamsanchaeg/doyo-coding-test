package doyoCodingtest.DoyoProgrammers.solution0623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution1 {

    //머쓱이는 학교에서 키 순으로 줄을 설 때 몇 번째로 서야 하는지 궁금해졌습니다.
    //머쓱이네 반 친구들의 키가 담긴 정수 배열 array와 머쓱이의 키 height가 매개변수로 주어질 때,
    //머쓱이보다 키 큰 사람 수를 return 하도록 solution 함수를 완성해보세요.

    public static void main(String[] args) throws IOException {
        System.out.println("머쓱이의 키를 입력하시오");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //머쓱이의 키 입력
        int height = Integer.parseInt(br.readLine());

        System.out.println("학급 친구들의 키를 입력하시오");
        // 사용자로부터 3개의 정수를 입력받아 배열에 저장
        // 배열의 갯수는 다섯개로 한정했는데, 문제 의도와 맞는건진 잘 모르겠다.
        /** 이런 배열 선언도 가능하다.
         int[] allStudentHeights = {170, 180, 165, 175, 168};
         int height = 170;
         int answer = 0;
         **/

        int[] allStudentHeights = new int[] {
                Integer.parseInt(br.readLine()),
                Integer.parseInt(br.readLine()),
                Integer.parseInt(br.readLine()),
                Integer.parseInt(br.readLine()),
                Integer.parseInt(br.readLine())
        };

        int answer = 0;

        /** 내가 초반에 작성했던 코드
         * for(int personalHeight=0; personalHeight < allStudentHeights.length ; personalHeight++ ){
               if (allStudentHeights[personalHeight] > height){
                        answer++;
               }
         }**/
        //향상된 for 문, 여기서 allStudentHeight는 반복문 내에서 사용될 임시 변수이다.
        for (int allStudentHeight : allStudentHeights) {
            if (allStudentHeight > height) {
                answer++;
            }
        }

        System.out.println("머쓱이보다 키가 큰 사람은" + answer + "명이네요!");
    }
}
