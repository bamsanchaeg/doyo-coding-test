package BasicCodingStudy.exception.basic.checked;

public class Service {

    Client client = new Client();

    //예외를 잡아서 처리하는 코드
    public void callCatch() {
        //예외가 잡히면,
        try {
            client.call();
        } catch (MyCheckedException e) {
            //잡아서 불을 꺼서 예외를 처리하고 예외메시지 출력
            System.out.println("예외처리, message = " + e.getMessage());
        }


        System.out.println("정상 흐름");
    }

    /*체크 예외를 밖으로 던지는 코드
    체크 예외는 예외를 잡지 않고 밖으로 던지려면 throws 예외를 메서드에 필수로 선언해야한다
    throws 는 해결못하면 아예 밖으로 던져버린다. 터져버리면 해결못하니까 밖으로 던져버리는거지. 둘 중 하나를 선택해야한다.
    여기서는 특정 Exception을 잡아서 처리해줘야 어떤 에러가 터지는지 알 수 있다.*/

    /**
     * 체크 예외의 장점 : 개발자가 실수로 예외를 누락하지 않도록 컴파일러를 통해 문제를 잡아주는 훌륭한 안전장치이다.
     * 이를 통해 어떤 체크 예외가 발생하는지 쉽게 파악할 수 있다.
     * 단점 : 하지만 모든 체크 예외를 반드시 잡거나 던지도록 처리해야 하기 때문에 번거로운 일이 된다.
     * 크게 신경쓰고 싶지 않은 예외까지 다 챙겨야 함
    **/

    public void catchThrow() throws MyCheckedException{
        client.call();
    }
}
