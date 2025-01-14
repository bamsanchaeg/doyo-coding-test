package BasicCodingStudy.exception.ex3.exception;

public class SendExceptionV3 extends NetworkClientExceptionV3 {
    private final String sendData;

    //파라미터 순서 바꾸기 단축키 option + shift + 방향키
    public SendExceptionV3(String sendData, String message){
        super(message);
        this.sendData = sendData;

    }


    public String getSendData(){
        return this.sendData;
    }


}
