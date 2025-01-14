package BasicCodingStudy.enumeration.ref3;

//enum은 static import를 하면 편리하게 사용할 수 있다. 상수에 사용할 수 있음

public class DiscountService {

    public int discount(Grade grade, int price) {

        return grade.discount(price);

    }
}
