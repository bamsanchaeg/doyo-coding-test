package BasicCodingStudy.nested.inner;

import BasicCodingStudy.nested.inner.InnerOuter.Inner;

public class InnerOuterMain {

    public static void main(String[] args) {
        InnerOuter outer = new InnerOuter();
        // 인스턴스의 참조 주소를 알아야 하기 떄문에 이러한 방향으로 생성해줘야함
        // 내부 클래스는 new 바깥클래스의 인스턴스 참조.내부클래스() 로 생성할 수 있다.
        // 내부 클래스는 바깥 클래스의 인스턴스에 소속되어야 한다. 따라서 내부 클래스를 생성할 때 바깥 클래스의 인스턴스 참조가 필요하다.
        // 바깥 클래스의 인스턴스를 먼저 생성해야 내부 클래스의 인스턴스를 생성할 수 있다.
        InnerOuter.Inner inner = outer.new Inner();

        inner.print();
        System.out.println("inner.getClass() = " + inner.getClass());
    }
}
