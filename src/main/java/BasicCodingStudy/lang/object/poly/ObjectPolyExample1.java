package BasicCodingStudy.lang.object.poly;

public class ObjectPolyExample1 {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();

        action(dog);
        action(car);
    }

    //Object 타입의 매개변수를 사용한다. 어떤 객체든지 인자로 전달할 수 있다.
    private static void action(Object obj) {

        //obj.sound(); // 컴파일 오류, Object는 sound()가 없다
        //obj.move(); // 컴파일 오류, Object는 move()가 없다.

        //객체에 맞는 다운캐스팅 필요
        if (obj instanceof Dog dog) {
            dog.sound();
        } else if (obj instanceof Car car) {
            car.move();
        }

    }
}
