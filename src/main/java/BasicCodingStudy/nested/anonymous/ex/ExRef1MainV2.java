package BasicCodingStudy.nested.anonymous.ex;

import java.util.Random;

public class ExRef1MainV2 {

    public static void hello(Process process) {
        System.out.println("프로그램 시작");
        process.run();
        System.out.println("프로그램 종료");
    }




    public static void main(String[] args) {

        class Dice implements Process {
            @Override
            public void run() {
                //코드 조각 시작
                int randomValue = new Random().nextInt(6) + 1;
                System.out.println("주사위 = " + randomValue);

            }
        }

        class Sum implements Process {
            @Override
            public void run() {
                //코드 조각 시작
                for (int i = 0; i < 3; i++) {
                    System.out.println("i = " + i);
                }
            }
        }

        hello(new Dice());
        hello(new Sum());

        //코드 조각을 넣어서 실행시킨다. 단순히 데이터를 전달하는 수준을 넘어 코드 조각을 전달해야 한다.
        //부모가 자식을 담을 수 있어서 Process로 선언해도 됨
        Dice dice = new Dice();
        Sum sum = new Sum();

        System.out.println("Hello 실행");
        hello(dice);
        hello(sum);
    }
}



/** 아래처럼도 가능
 * public static void main(String[] args) {
 *
 *     Process dice = new Process() {
 *         @Override
 *         public void run() {
 *             //코드 조각 시작
 *             int randomValue = new Random().nextInt(6) + 1;
 *             System.out.println("주사위 = " + randomValue);
 *
 *         }
 *     }
 *
 *     Process sum = new Process() {
 *         @Override
 *         public void run() {
 *             //코드 조각 시작
 *             for (int i = 0; i < 3; i++) {
 *                 System.out.println("i = " + i);
 *             }
 *         }
 *     }
 *
 *     hello(new Dice());
 *     hello(new Sum());
 *
 *     //코드 조각을 넣어서 실행시킨다. 단순히 데이터를 전달하는 수준을 넘어 코드 조각을 전달해야 한다.
 *     //부모가 자식을 담을 수 있어서 Process로 선언해도 됨
 *
 *     System.out.println("Hello 실행");
 *     hello(dice);
 *     hello(sum);
 * }
 * **/


