package BasicCodingStudy.exception.ex1;


public class NetworkServiceV1_2 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);

        client.initError(data);
        String connectResult = client.connect();
        //결과가 성공이 아니다 -> 오류다(이게 더 쉬운 말임)
        //메서드 검색할떄 : ctr + T
        //Extract Method : option + cmd + M
        if (isError(connectResult)) {
            System.out.println("[네트워크 오류 발생] 오류 코드 : " + connectResult);
            return;
        }

        String sendResult = client.send(data);
        if (isError(sendResult)) {
            System.out.println("[네트워크 오류 발생] 오류 코드 : " + sendResult);
            return;
        }

        client.disconnect();
    }

    //메서드 명으로 복잡한 것을 빼버림
    private static boolean isError(String connectResult) {
        return !connectResult.equals("success");
    }
}
