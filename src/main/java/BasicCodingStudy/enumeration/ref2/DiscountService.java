package BasicCodingStudy.enumeration.ref2;


//enum은 static import를 하면 편리하게 사용할 수 있다. 상수에 사용할 수 있음

public class DiscountService {

    public int discount(Grade grade, int price) {

        //10000 * (20/100) -> 2천원
        return price * grade.getDiscountPercent() / 100;
    }
}
