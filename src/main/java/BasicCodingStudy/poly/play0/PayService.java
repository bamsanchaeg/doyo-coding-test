package BasicCodingStudy.poly.play0;

public class PayService {

    //중복으로 수행되는 부분을 쪼개보자

    public void processPay(String option, int amount) {
        boolean result = false;
        System.out.println("결제를 시작합니다: : option =" + option + ",amount = " + amount);

        Pay pay = PayStore.findPay(option);
        if (pay != null) {
            result = pay.pay(amount);
        }

        if (result) {
            System.out.println("결제가 성공했습니다.");
        } else {
            System.out.println("결제가 실패했습니다.");
        }


    }




}
