package BasicCodingStudy.exception.ex3;

import java.util.Scanner;

public class MainV3 {

    //main 밖으로 예외가 던져지면 예외 메세지와 예외를 추적할 수 있는 스택 트레이스를 출력하고 프로그램을 종료한다.
    //오류메세지를 잘 지정하지 않으면 내가 고생한다 내가... 잘 지정하기
    public static void main(String[] args) {

        NetworkServiceV3_1 networkService = new NetworkServiceV3_1();

        Scanner scanner = new Scanner(System.in);
        //에러를 빠져나가고 정상흐름으로 돌아가기때문에 다시 문자를 받을 수 있다.
        while (true) {
            System.out.print("전송할 문자. : ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            networkService.sendMessage(input);
            System.out.println();
        }
        System.out.println("프로그램을 정상 종료합니다.");
    }
}
