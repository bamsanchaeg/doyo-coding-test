package BasicCodingStudy.poly.play0;

import java.util.Scanner;

public class PayMain2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PayService payService = new PayService();


        while (true){
            //Kakao 결제
            System.out.println("결제 수단을 입력하세요.");
            String payOption = scanner.nextLine();


            if(payOption.equals("exit")){
                System.out.println("프로그램을 종료합니다.");
                return;
            }

            System.out.println("결제 금액을 입력하세요.");
            int amount = scanner.nextInt();
            scanner.nextLine();

            payService.processPay(payOption, amount);


        }

    }
}
