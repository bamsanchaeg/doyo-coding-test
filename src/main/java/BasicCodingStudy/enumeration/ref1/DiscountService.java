package BasicCodingStudy.enumeration.ref1;


public class DiscountService {

    public int discount(ClassGrade classGrade, int price) {
        //inline : option + command + N
        return price * classGrade.getDiscountPercent() / 100;
    }
}
