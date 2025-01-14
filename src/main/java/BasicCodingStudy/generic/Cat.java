package BasicCodingStudy.generic;

public class Cat extends Animal {

    public Cat(String name, int size) {
        //부모 클래스에 정의된 생성자가 있기 떄문에 맞추어 super(name,size를 호출한다)
        super(name, size);
    }

    @Override
    public void sound() {
        System.out.println("냐옹");
    }
}
