package BasicCodingStudy.exception.basic.checked;

public class CheckedThrowMain {

    //부모타입을 지정해두면 자식타입까지 다 던져버리겠다는 뜻(Exception)
    public static void main(String[] args) throws Exception {
        Service service = new Service();
        service.catchThrow(); //여기서 예외를 던져버리면 예외메세지를 출력하고 종료함.
        //stachtrace -- 예외가 어디서 출력되는지
        System.out.println("정상 종료 ");
    }
}
