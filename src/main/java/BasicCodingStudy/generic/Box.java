package BasicCodingStudy.generic;

//객체를 보관할 수 있다
public class Box<T> {

    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }


}
