package BasicCodingStudy.immutable.address;

public class ImmutableObj {

    //final인 경우 setter를 생성하지 못함, final은 절대로 바뀌면 안됨
    private final int value;

    public ImmutableObj(int value) {
        this.value = value;
    }

    public ImmutableObj add(int addValue){
        int result = value + addValue;
        return new ImmutableObj(result);
    }

    public int getValue() {
        return value;
    }


}
