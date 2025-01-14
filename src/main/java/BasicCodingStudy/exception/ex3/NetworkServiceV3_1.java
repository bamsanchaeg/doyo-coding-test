package BasicCodingStudy.exception.ex3;


import BasicCodingStudy.exception.ex3.exception.ConnectExceptionV3;
import BasicCodingStudy.exception.ex3.exception.SendExceptionV3;

public class NetworkServiceV3_1 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV3 client = new NetworkClientV3(address);

        client.initError(data);

        //try 안에 정상흐름이 있고, catch안에 예외 흐름이 있다.
        //finally 는 예외가 터져도 무조건 실행된다. try-catch-finally 순으로 실행된다.
        //잡을 수 없는 예외가 터져도 finally 부분에서 코드가 무조건 실행됨. 사용한 자원을 항상 보장해 줄 수 있도록 한다.
        //예외 틀래스를 각각의 예외상황에 맞춰서 만들면 각각의 예외 클래스가 가지는 고유의 기능을 활용할 수 있다.
        try {
            client.connect();
            client.send(data);
        } catch (ConnectExceptionV3 e) {
            System.out.println("[연결 오류] 주소: " + e.getAddress() + ", 메세지: " + e.getMessage());
        } catch (SendExceptionV3 e) {
            System.out.println("[전송 오류] 전송 데이터: " + e.getSendData() + ", 메세지 : " + e.getMessage());
        } finally {
            client.disconnect();
        }

    }

    //메서드 명으로 복잡한 것을 빼버림
    private static boolean isError(String connectResult) {
        return !connectResult.equals("success");
    }
}
