package BasicCodingStudy;

public class ExampleOfGeneric {

    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<>(); //생성 시점에 T의 타입 결정
        integerBox.set(10);
        //integerBox.set("100");//컴파일 오류, 타입허용은 integer만;
        Integer integer = integerBox.get(); //Integer타입변환(캐스팅 x)
        System.out.println("Integer : " + integer);

        GenericBox<String> stringBox = new GenericBox<>(); //생성 시점에 T의 타입 결정
        stringBox.set("이것은 문자열 박스이다");
        String string = stringBox.get();
        System.out.println("string : " + string);

    }
}
