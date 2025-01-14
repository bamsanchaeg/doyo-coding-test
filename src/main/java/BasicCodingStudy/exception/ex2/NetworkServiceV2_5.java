package BasicCodingStudy.exception.ex2;



public class NetworkServiceV2_5 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);

        client.initError(data);

        //try 안에 정상흐름이 있고, catch안에 예외 흐름이 있다.
        //finally 는 예외가 터져도 무조건 실행된다. try-catch-finally 순으로 실행된다.
        //잡을 수 없는 예외가 터져도 finally 부분에서 코드가 무조건 실행됨. 사용한 자원을 항상 보장해 줄 수 있도록 한다.
        try{
            client.connect();
            client.send(data);
        }catch (NetworkClientExceptionV2 e){
            //안에 생성자가 있어서 받아오기
            System.out.println("[오류] 코드 : " + e.getErrorCode() + ", 메시지" + e.getMessage());
        }finally {
            client.disconnect();
        }

    }

    //메서드 명으로 복잡한 것을 빼버림
    private static boolean isError(String connectResult) {
        return !connectResult.equals("success");
    }
}
