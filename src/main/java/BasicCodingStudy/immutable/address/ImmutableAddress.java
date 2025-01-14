package BasicCodingStudy.immutable.address;

public class ImmutableAddress {

    private String value;
    public ImmutableAddress(String value){ this.value = value;}
    public String getValue() { return value;}
    public void setValue(String value){this.value = value;}

    @Override
    public String toString() {
        return "ImmutableAddress{" +
                "value='" + value + '\'' +
                '}';
    }
}
