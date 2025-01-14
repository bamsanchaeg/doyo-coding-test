package BasicCodingStudy.exception.ex1;


public class NetworkServiceV1_3 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);

        client.initError(data);
        String connectResult = client.connect();

        //정상 흐름이 보이지 않으면 가독성이 떨어진다. 그래서 이 부분에 있어서 깔끔하게 보여야 한다.
        //정상 흐름이 제일 중요하고 이 부분이 눈에 더 많이 들어와야한다.

        if (isError(connectResult)) {
            System.out.println("[네트워크 오류 발생] 오류 코드 : " + connectResult);

        } else {
            String sendResult = client.send(data);
            if (isError(sendResult)) {
                System.out.println("[네트워크 오류 발생] 오류 코드 : " + sendResult);

            }
        }

        client.disconnect();
    }

    //메서드 명으로 복잡한 것을 빼버림
    private static boolean isError(String connectResult) {
        return !connectResult.equals("success");
    }
}
