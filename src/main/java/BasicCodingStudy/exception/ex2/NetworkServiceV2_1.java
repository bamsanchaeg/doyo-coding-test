package BasicCodingStudy.exception.ex2;




public class NetworkServiceV2_1 {

    //체크예외를 받으면 던지거나 처리하는 방법이 있는데 여기서는 던지겠다.
    public void sendMessage(String data )throws NetworkClientExceptionV2{
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);

        client.initError(data);
        client.connect();
        client.send(data);
        client.disconnect();
    }
}
