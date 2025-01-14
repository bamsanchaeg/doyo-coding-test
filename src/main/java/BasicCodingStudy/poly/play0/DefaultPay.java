package BasicCodingStudy.poly.play0;

//null 대신에 쓴다고 해서 nullObject라고도 한다.
public class DefaultPay implements Pay{
    @Override
    public boolean pay(int amount) {
        System.out.println("결제 수단이 없습니다.");
        return false;
    }
}
