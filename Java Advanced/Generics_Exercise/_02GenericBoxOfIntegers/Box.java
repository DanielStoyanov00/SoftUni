package _02GenericBoxOfIntegers;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> values;


    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        this.values.add(element);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T value : this.values) {
            builder.append(String.format("%s: %s", value.getClass().getName(), value));
            builder.append(System.lineSeparator());

        }
        return builder.toString();
    }
}
