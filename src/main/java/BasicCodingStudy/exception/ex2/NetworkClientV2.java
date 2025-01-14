package BasicCodingStudy.exception.ex2;

public class NetworkClientV2 {

    private final String address;
    public boolean connectError;
    public boolean sendError;

    public NetworkClientV2(String address) {
        this.address = address;
    }

    public String connect() throws NetworkClientExceptionV2{
        //체크예외이기 때문에 예외를 던져줘야한다.
        if (connectError) {
            throw new NetworkClientExceptionV2("connectError",address + "서버연결 실패");

        }
        //연결 성공
        System.out.println(address + " 서버 연결 성공");
        return "success";
    }

    public String send(String data)throws NetworkClientExceptionV2 {

        if (sendError) {
            throw new NetworkClientExceptionV2("sendError", address + "서버에 데이터 전송 실패" + data);
        }
        //전송 성공
        System.out.println(address + "서버에 데이터 전송 :" + data);
        return "succes";
    }

    public void disconnect() {
        System.out.println(address + "서버 연결 해제");
    }

    public void initError(String data){
        if(data.contains("error1")){
            connectError = true;
        }

        if(data.contains("error2")){
            sendError = true;
        }
    }
}
