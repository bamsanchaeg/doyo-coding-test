package BasicCodingStudy.lang.object;


//부모가 없으면 묵시적으로 Object 클래스를 상속받는다
//클래스에 상속받을 부모 클래스가 없으면 묵시적으로 Object 클래스를 상속받는다.
//자바가 extends Object 코드를 넣어준다.(생략하는 것을 권장함)
public class Parent {

    public void parentMethod(){
        System.out.println("Parent.parentMethod"); //soutm 클래스명 + 메소드명
    }
}
