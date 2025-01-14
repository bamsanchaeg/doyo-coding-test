package BasicCodingStudy.generic;

public class Animal {
    //이름 크기 정보를 가지는 부모클래스이다
    private String name;
    private int size;

    public Animal(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public void sound() {
        System.out.println("동물 울음 소리");
    }

    //toString을 IDE를 사용해서 오버라이딩 함
    @Override
    public String toString() {
        return "Animal{" +
                "name = " + name + '\'' +
                ",size = " + size +
                '}';
    }
}
