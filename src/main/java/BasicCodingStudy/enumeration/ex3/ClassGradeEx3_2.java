package BasicCodingStudy.enumeration.ex3;


import BasicCodingStudy.enumeration.ex2.DiscountService;

public class ClassGradeEx3_2 {

    public static void main(String[] args) {
        int price = 10000;
        DiscountService discountService = new DiscountService();

        //enum 타입은 인스턴스화 할 수 없다.
       /*
        Grade grade = new Grade();
        int result = discountService.discount(grade,price);
        System.out.println("result price : " + result);
        */

    }


}
