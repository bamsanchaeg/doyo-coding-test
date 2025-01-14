package BasicCodingStudy.exception.ex2;

public class NetworkClientExceptionV2 extends Exception {
    private String errorCode;


    //클래스 안의 생성자다
    public NetworkClientExceptionV2(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }


    //예외도 객체기 때문에 따라서 반환할 수 있다
    public String getErrorCode() {
        return errorCode;
    }
}
