package BasicCodingStudy.nested.anonymous.ex;

import java.util.Random;

public class ExRef1MainV1 {

    public static void hello(Process process) {
        System.out.println("프로그램 시작");
        process.run();
        System.out.println("프로그램 종료");
    }

    static class Dice implements Process {
        @Override
        public void run() {
            //코드 조각 시작
            int randomValue = new Random().nextInt(6) + 1;
            System.out.println("주사위 = " + randomValue);

        }
    }

    static class Sum implements Process {
        @Override
        public void run() {
            //코드 조각 시작
            for (int i = 0; i < 3; i++) {
                System.out.println("i = " + i);
            }
        }
    }


    public static void main(String[] args) {
        hello(new Dice());
        hello(new Sum());

        //코드 조각을 넣어서 실행시킨다. 단순히 데이터를 전달하는 수준을 넘어 코드 조각을 전달해야 한다.
        Dice dice = new Dice();
        Sum sum = new Sum();

        System.out.println("Hello 실행");
        hello(dice);
        hello(sum);
    }
}
