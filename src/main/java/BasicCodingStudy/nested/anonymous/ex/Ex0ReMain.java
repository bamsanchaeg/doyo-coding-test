package BasicCodingStudy.nested.anonymous.ex;

public class Ex0ReMain {

    public static void hello(String str) {
        System.out.println("프로그램 시작"); //변하지 않는 부분

        //변하는 부분 시작
        System.out.println(str); //변하는 부분

        //변하는 부분 종료
        System.out.println("프로그램 종료"); //변하지 않는 부분
    }

    public static void main(String[] args) {
        hello("Hello Java");
        hello("Hello Spring");
    }
}
