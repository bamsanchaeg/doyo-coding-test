package BasicCodingStudy.generic;

public class Dog extends Animal {

    public Dog(String name, int size){
        super(name,size);
    }

    public void sound(){
        System.out.println("멍멍");
    }
}
