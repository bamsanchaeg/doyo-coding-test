package doyoCodingtest.DoyoProgrammers.Solution0707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 중앙값은 어떤 주어진 값들을 크기의 순서대로 정렬했을 때 가장 중앙에 위치하는 값을 의미합니다.
 예를 들어 1, 2, 7, 10, 11의 중앙값은 7입니다.
 정수 배열 array가 매개변수로 주어질 때, 중앙값을 return 하도록 solution 함수를 완성해보세요.
 **/

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //여기서 입력 유효성 검사 추가같은걸 해야할지(선택적)
        System.out.println("배열에 선언된 다섯개의 숫자를 입력하시오");
        int[] number = new int[]{
                Integer.parseInt(reader.readLine()),
                Integer.parseInt(reader.readLine()),
                Integer.parseInt(reader.readLine()),
                Integer.parseInt(reader.readLine()),
                Integer.parseInt(reader.readLine())
        };
        int medion = solution(number); //아래 선언된 메소드 변수로 불러오기
        System.out.println("배열의 중앙값은" + medion);
    }

    //public과 static에 대한 개념 다시 복습이 필요할 것 같음.
    public static int solution(int[] number) {
        //배열을 오름차순으로 정리해주는 API, 이 부분을 기억하자.
        Arrays.sort(number);
        //선택적 : 중앙값 찾은 후 조기 리턴
        return number[number.length/2];
    }
}
