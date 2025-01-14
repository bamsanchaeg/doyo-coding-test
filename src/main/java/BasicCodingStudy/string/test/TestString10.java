package BasicCodingStudy.string.test;

public class TestString10 {

    public static void main(String[] args) {
        String fruits = "apple,banana,mango";

        //분리하기
        String[] splitFruits = fruits.split(",");
        for (String splitFruit : splitFruits) {
            System.out.println(fruits);
        }

        //합치기
        String joinedString = String.join("->", splitFruits);
        System.out.println("joinedString = " + joinedString);
    }
}
