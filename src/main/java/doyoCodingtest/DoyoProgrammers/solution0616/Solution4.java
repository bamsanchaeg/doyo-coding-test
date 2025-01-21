package doyoCodingtest.DoyoProgrammers.solution0616;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//정수 num1과 num2가 매개변수로 주어질 때,
//num1을 num2로 나눈 값에 1,000을 곱한 후
//정수 부분을 return 하도록 soltuion 함수를 완성해주세요.

//코멘트 :
//int 를 int 로 나누는 것과 double을 나누는 것에 대한 부분이 헷갈려서 테스트 케이스가 맞지 않는 경우가 많이 발생했다.
//이 부분에 있어서 기본적인 개념 숙지가 필요한 것 같아 추가로 인강을 들을 예정.

public class Solution4 {

    public static void main(String[] args) throws Exception {

        System.out.println("숫자 두개를 차례대로 입력하세요");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //첫번째 입력된 수
        int num1 = Integer.parseInt(br.readLine());
        //두번째 입력된 수
        int num2 = Integer.parseInt(br.readLine());

        int answer = 0;

        double div = (double)num1/(double)num2;
        double sum = div * 1000;
        answer = (int)sum;

        System.out.println(answer);

    }
}
