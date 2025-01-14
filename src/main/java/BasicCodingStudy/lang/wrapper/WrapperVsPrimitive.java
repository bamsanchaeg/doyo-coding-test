package BasicCodingStudy.lang.wrapper;

public class WrapperVsPrimitive {

    public static void main(String[] args) {
        int iterations = 1_000_000_000; //반복 횟수 설정, 10억
        long startTime, endTime;

        //기본형 long
        long sumPrimitive = 0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            sumPrimitive += i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("sumPrimitive = " + sumPrimitive);
        System.out.println("기본 자료형 long 실행시간 : " + (endTime - startTime) + "ms");

        //래퍼 클래스 long 사용
        //실행시간이 더 많이 걸린다.
        Long sumWrapper = 0L;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            sumWrapper += i; //오토 박싱 발생
        }
        endTime = System.currentTimeMillis();
        System.out.println("sumPrimitive = " + sumWrapper);
        System.out.println("래퍼 클래스 Long 실행시간 : " + (endTime - startTime) + "ms");
    }
}
