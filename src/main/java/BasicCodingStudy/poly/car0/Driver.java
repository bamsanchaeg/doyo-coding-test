package BasicCodingStudy.poly.car0;

public class Driver {

    //인스턴스를 생성하면 기본이 Null값이다.
    //인터페이스를 선언한다는 것, 의존하는 것
    private K3Car k3Car;
    private Model3Car model3Car;

    public void setK3Car(K3Car k3Car){
        this.k3Car = k3Car;
    }

    public void setModel3Car(Model3Car model3Car){
        this.model3Car = model3Car;
    }

    public void drive(){
        System.out.println("자동차를 운전합니다.");
        if(k3Car != null){
            k3Car.startEngine();
            k3Car.pressAccelerator();
            k3Car.offEngine();
        }else if(model3Car != null){
            model3Car.startEngine();
            model3Car.pressAccelerator();
            model3Car.offEngine();
        }

    }


}
