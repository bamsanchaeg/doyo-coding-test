package BasicCodingStudy.exception.ex2;



public class NetworkServiceV2_4 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);

        client.initError(data);

        //try 안에 정상흐름이 있고, catch안에 예외 흐름이 있다.

        try{
            client.connect();
            client.send(data);
        }catch (NetworkClientExceptionV2 e){
            //안에 생성자가 있어서 받아오기
            System.out.println("[오류] 코드 : " + e.getErrorCode() + ", 메시지" + e.getMessage());
        }

        //중간에 에러가 발견해도 코드가 실행되지만 문제가있다.
        //Catch에서 잡을 수 없는 예외가 발생한다면? RuntimeException은 unchecked예외이다.
        //이 경우엔 항상 호출해야하는 이 코드를 호출하는게 어려울 수 있다.
        client.disconnect();


    }

    //메서드 명으로 복잡한 것을 빼버림
    private static boolean isError(String connectResult) {
        return !connectResult.equals("success");
    }
}
