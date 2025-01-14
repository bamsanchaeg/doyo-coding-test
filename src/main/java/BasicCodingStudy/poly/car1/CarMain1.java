package BasicCodingStudy.poly.car1;

//Main과 같이 새로운 차를 생성하고 Driver에게 필요한 차를 전달해주는 역할은 전체 프로그램을 설정하고 조율하는 역할을 한다.
// 이런 부분은 OCP를 지켜도 변경이 필요하다.

public class CarMain1 {
    public static void main(String[] args) {
        Driver driver = new Driver();

        //차량선택(K3);
        K3Car k3Car = new K3Car();
        driver.setCar(k3Car);

        //차량 변경(k3 -> model3)
        Model3Car model3Car = new Model3Car();
        driver.setCar(model3Car);
        driver.drive();;

        //차량 변경(Model3 -> newCar)
        //추가 과정에서 driver 코드를 절대 손대지 않았음
        NewCar newCar = new NewCar();
        driver.setCar(newCar);
        driver.drive();;


    }
}
