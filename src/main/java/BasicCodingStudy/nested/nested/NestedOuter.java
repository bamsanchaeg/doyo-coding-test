package BasicCodingStudy.nested.nested;

public class NestedOuter {

    //static이라서 인스턴스와 아무 관계가 없음
    private static int outClassValue = 3;
    private int outInstanceValue = 2;

    static class Nested {
        private int nestedInstanceValue = 1;

        public void print() {

            //자신의 멤버에 접근
            System.out.println(nestedInstanceValue);

            //바깥 클래스의 인스턴스 멤버의 접근에는 접근할 수 없다
            //Static은 메서드 영역에 생긴다고 봐야함.
            // System.out.println(outInstanceValue);

            //바깥 클래스의 클래스 멤버에는 접근할 수 있다. private 도 접근 가능
            System.out.println(outClassValue);

        }

    }
}
