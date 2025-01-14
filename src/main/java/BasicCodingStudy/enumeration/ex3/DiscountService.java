package BasicCodingStudy.enumeration.ex3;


//enum은 static import를 하면 편리하게 사용할 수 있다. 상수에 사용할 수 있음
import static BasicCodingStudy.enumeration.ex3.Grade.*;

public class DiscountService {

    public int discount(Grade classGrade, int price) {
        int discountPercent = 0;

        if (classGrade == BASIC) {
            discountPercent = 10;
        } else if (classGrade == GOLD) {
            discountPercent = 20;
        } else if (classGrade == DIAMOND) {
            discountPercent = 30;
        } else {
            System.out.println("할인X");
        }

        //10000 * (20/100) -> 2천원
        return price * discountPercent / 100;
    }
}
