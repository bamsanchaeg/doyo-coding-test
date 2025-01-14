package BasicCodingStudy.exception.basic.uncheked;


public class Client {

    public void call() {
        throw new MyUncheckedException("ex");
    }
}
