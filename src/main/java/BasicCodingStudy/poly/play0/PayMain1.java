package BasicCodingStudy.poly.play0;

public class PayMain1 {

    public static void main(String[] args) {

        PayService payService = new PayService();

        //Kakao 결제
        String payOption1 = "kakao";
        int amount1 = 5000;
        payService.processPay(payOption1, amount1);

        //
        //Kakao 결제
        String payOption2 = "naver";
        int amount2 = 10000;
        payService.processPay(payOption2, amount2);

        //잘못된 결제
        String bad = "bad";
        int amount3 = 10000;
        payService.processPay(bad, amount3);

        //새로운 결제 수단
        String payOption4 = "new";
        int amount4 = 12000;
        payService.processPay(payOption4,amount4);
    }
}
