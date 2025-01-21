package doyoCodingtest.DoyoProgrammers.Solution0630;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//대소문자 변환
//String 클래스의 toUpperCase()와 toLowerCase()를 사용하면 된다.
//equalsIgnoreCase()로 대소문자 구분없이 문자열 비교 가능
//아래는 원래 구성하고 통과했던 것
//charAt() 메서드는 String 객체 s 에서 i번째 문자를 추출하여 char 변수 c 에 할당하는 데 사용된다.
//즉, 문자열의 특정 위치에 있는 문자를 하나만 가져와 변수에 저장하는 역할을 합니다.

/** for(int i=0;i<s.length();i++){
        char c = s.charAt(i);
                if(Character.isUpperCase(c)){
        answer += Character.toLowerCase(c);
                }else {
        answer += Character.toUpperCase(c);
                }
                        }
 **/
public class Solution1 {

    public static void main(String[] args) throws IOException {
        System.out.println("알파벳을 입력하세요!");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder answer = new StringBuilder();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)){
                answer.append(Character.toLowerCase(c));
            }else {
                answer.append(Character.toUpperCase(c));
            }
        }

        System.out.println(answer);
    }

}
