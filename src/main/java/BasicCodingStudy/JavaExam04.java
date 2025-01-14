package BasicCodingStudy;

public class JavaExam04 {

    public static void main(String[] args) {

        String exmaple1 = "12345211";

        //시작 시간 읽기
        long time1 = System.nanoTime();

        int sum = 0;
        for (int i = 1; i <= 100000; i++) {
            sum += i;
        }

        long time2 = System.nanoTime();//끝시간 읽기

        System.out.println("1~1000000R까지의 합:" + sum);
        System.out.println("계산에 " + (time2 - time1) + "나노초가 사용되었습니다.");

    }
}
