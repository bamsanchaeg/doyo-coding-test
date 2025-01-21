package doyoCodingtest.DoyoProgrammers.Solution0630;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 군 전략가 머쓱이는 전쟁 중 적군이 다음과 같은 암호 체계를 사용한다는 것을 알아냈습니다.
 암호화된 문자열 cipher를 주고받습니다.
 그 문자열에서 code의 배수 번째 글자만 진짜 암호입니다.
 문자열 cipher와 정수 code가 매개변수로 주어질 때 해독된 암호 문자열을 return하도록 solution 함수를 완성해주세요.
 **/

public class Solution3 {

    public static void main(String[] args) throws IOException {

        System.out.println("암호 코드를 입력하세요");
        System.out.println("암호 코드숫자를 입력하세요");
        BufferedReader code =new BufferedReader(new InputStreamReader(System.in));
        String str = code.readLine();
        int code2 = Integer.parseInt(code.readLine());
        System.out.println("코드는 : " + code2);

        //irng은 변경 불가능한 문자열을 생성하지만 StringBuilder는 변경 가능한 문자열을 만들어 준다.
        //String을 합치는 작업 시 하나의 대안이 될 수 있다.
        StringBuilder answer = new StringBuilder();

        //code-1을 i에 할당해주는법과, Array length 를 풀로 떙겨서 i에서 -1를 해주는 법이 있음.
        //근데 초기값에 수식을 걸어 할당하는게 이상하다는 의견도 있고... 뭐가 정답인지는 잘 모르겠다.
        for(int i=code2; i<=str.length(); i+=code2){
            answer.append(str.charAt(i-1));
        }

        System.out.println("이 문자의 암호는" + answer);
    }
}
