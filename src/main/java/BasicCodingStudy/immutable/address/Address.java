package BasicCodingStudy.immutable.address;

public class Address {

    private String value;

    public Address(String address) {
        this.value = address;
    }

    public String getValue(String address) {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Address{" +
                "value='" + value + '\'' +
                '}';
    }
}
