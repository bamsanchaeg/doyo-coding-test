package BasicCodingStudy.generic;

public class AnimalMain2 {

    public static void main(String[] args) {
        Animal animal = new Animal("동물", 0);
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("냐옹이", 50);

        Box<Animal> animalBox = new Box<>();
        animalBox.set(animal);
        animalBox.set(dog); //Animal = Dog
        animalBox.set(cat); //Animal = Cat, 마지막에 들어간거라 이렇게 나온 것
        Animal findAnimal = animalBox.get(); //애니멀 타입으로 나옴, 하지만 애니멀의 자식으로 나옴
        System.out.println("findAnimal = " + findAnimal);
    }
}
