package BasicCodingStudy.set;

import java.util.Arrays;

public class MyHashSetV0 {
    public int[] elementData = new int[10];
    private int size = 0;

    public boolean add(int value) {

        if (contains(value)) {
            return false;
        }
        elementData[size] = value;
        size++;
        return true;
    }

    public boolean contains(int value) {
        for (int data : elementData) {
            if (data == value) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "MyHashSetV0{" +
                "elementData=" + Arrays.toString(Arrays.copyOf(elementData, size)) +
                ", size=" + size +
                '}';
    }
}
