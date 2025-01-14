package BasicCodingStudy.exception.ex2;

import java.util.Scanner;

public class MainV2 {

    //main 밖으로 예외가 던져지면 예외 메세지와 예외를 추적할 수 있는 스택 트레이스를 출력하고 프로그램을 종료한다.
    //오류메세지를 잘 지정하지 않으면 내가 고생한다 내가... 잘 지정하기
    public static void main(String[] args) {
        //주석처리 : ctr + shift + /
        //NetworkServiceV1_1 networkService = new NetworkServiceV1_1();*/
        //외부 자원은 꼭 해결해줘야한다.(닫아줘야한다)
        //NetworkServiceV1_2 networkService = new NetworkServiceV1_2();
        NetworkServiceV2_3 networkService = new NetworkServiceV2_3();

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
