package BasicCodingStudy.exception.basic.checked;

public class Client {

    //나는 이 예외를 체크하지 못해서 밖으로 던질거야
    //throw : 예외를 발생시킴
    //throws : 발생시킨 예외를 메서드 밖으로 던질때 사용하는 키워드이다.
    public void call() throws MyCheckedException{
        //문제 상황
        throw new MyCheckedException("ex");
    }
}
