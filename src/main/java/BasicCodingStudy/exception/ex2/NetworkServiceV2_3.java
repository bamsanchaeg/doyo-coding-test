package BasicCodingStudy.exception.ex2;



public class NetworkServiceV2_3 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);

        client.initError(data);

        //try 안에 정상흐름이 있고, catch안에 예외 흐름이 있다.
        //중간에 에러가 터지면 에러가 호출되어서 마지막 disconnect가 호출이 안됨
        try{
            client.connect();
            client.send(data);
            client.disconnect();
        }catch (NetworkClientExceptionV2 e){
            //안에 생성자가 있어서 받아오기
            System.out.println("[오류] 코드 : " + e.getErrorCode() + ", 메시지" + e.getMessage());
        }



    }

    //메서드 명으로 복잡한 것을 빼버림
    private static boolean isError(String connectResult) {
        return !connectResult.equals("success");
    }
}
