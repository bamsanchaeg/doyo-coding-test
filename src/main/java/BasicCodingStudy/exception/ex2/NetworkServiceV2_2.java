package BasicCodingStudy.exception.ex2;



public class NetworkServiceV2_2 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);

        client.initError(data);

        //예외를 잡으면 오류 코드와 예외 메세지를 출력한다.
        //예외를 잡아서 처리했기 떄문에 이후에는 정상 흐름으로 복귀한다.
        //여기서는 리턴을 사용해서 sendMessage() 메서드를 정상적으로 빠져나간다.
        try{
            client.connect();
        }catch (NetworkClientExceptionV2 e){
            //안에 생성자가 있어서 받아오기
            System.out.println("[오류] 코드 : " + e.getErrorCode() + ", 메시지" + e.getMessage());
            return;
        }


        try {
            client.send(data);
        }catch (NetworkClientExceptionV2 e){
            System.out.println("[오류] 코드 : " + e.getErrorCode() + ", 메시지" + e.getMessage());
            return;
        }


        client.disconnect();
    }

    //메서드 명으로 복잡한 것을 빼버림
    private static boolean isError(String connectResult) {
        return !connectResult.equals("success");
    }
}
