package BasicCodingStudy.enumeration.ex3;

import java.util.Arrays;

public class EnumMethodMain {

    public static void main(String[] args) {

        //모든 ENUM 반환
        Grade[] values = Grade.values();
        //Arrays.toString()은 배열의 참조값이 아니라 배열 내부의 값을 출력할때 사용한다.
        System.out.println("values = " + Arrays.toString(values));
        for(Grade value : values){
            System.out.println("name = " + value.name() + ", original=" + value.ordinal());
        }

        //String -> ENUM 변환
        String input = "GOLD";
        Grade gold = Grade.valueOf(input);
        System.out.println("gold = " + gold);

        /**
         * ENUM 주요 메서드
         * values() : 모든 ENUM 상수를 포함하는 배열을 반환한다
         * valueOf(String name) : 주어진 이름과 일치하는 ENUM 상수를 반환한다.
         * name() : ENUM 상수의 이름을 문자열로 반환한다.
         * ordinal() : ENUM 상수의 선언 순서(0부터 시작)를 반환한다.
         * toString() : ENUM 상수의 이름을 문자열로 반환한다. name() 메서드와 유사하지만, toString()은 직접 오버라이드 할 수 있다.
         * **/

        //ordinal은 가급적 사용하지 않는게 좋다. 이 값을 사용하다가 중간에 상수를 선언하는 위치가 변경되면 전체 상수의 위치가 모두 변경될 수 있기 때문이다.
        //예를 들어 중간에 BASIC 다음에 SILVER 등급이 추가되는 경우 GOLD, DIAMOND 의 값이 하나씩 추가된다.
        //이 경우 기존값의 등급이 바뀌는 상황이 발생할수도 있음
    }
}
