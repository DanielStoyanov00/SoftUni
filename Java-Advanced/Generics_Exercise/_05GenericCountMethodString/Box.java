package _05GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        this.values.add(element);
    }

    public int count(T element) {
        int greaterThanElementFromOutside = 0;
        for (T value : values) {
            if (value.compareTo(element) > 0) {
                greaterThanElementFromOutside++;
            }
        }

        return greaterThanElementFromOutside;
    }


}
