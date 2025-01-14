package BasicCodingStudy.immutable.test;

public class ImmutableMyDateMain {

    public static void main(String[] args) {
        ImmutableMyDate date1 = new ImmutableMyDate(2024, 1, 1);
        ImmutableMyDate date2 = date1;
        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date1);

        System.out.println("2025 -> date1");
        //date1.setYear(2025);
        //새로운 객체 반환(반환값을 무조건 받아서 참조를 가져야 값이 바뀐걸 쓸 수 있다. 아무것도 안하면 새로 바뀐 값은 버려진다)
        //불변객체에서 원본 객체의 상태가 그대로 유지됨을 강조하면서 변경사항을 새 복사본에 포함하는 과정을 간결하게 포함한다.
        //set은 내꺼의 값을 바꾼다는 의미가 있고.. setter를 사용하면 안됨
        //사이드 이펙트 문제가 생기면 진짜 골치아픔... 초창기 설계가 정말 중요하다.
        date1 = date1.withYear(2025);
        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date1);
    }
}
