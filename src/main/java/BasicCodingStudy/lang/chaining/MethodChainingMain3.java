package BasicCodingStudy.lang.chaining;

public class MethodChainingMain3 {
    public static void main(String[] args) {
        ValueAdder adder = new ValueAdder();

        //메서드 체인닝, 같은 메모리 주소를 공유해서 메서드가 연결됨
        int result = adder.add(1).add(2).add(3).getValue();
        System.out.println("result = " + result);

    }
}
