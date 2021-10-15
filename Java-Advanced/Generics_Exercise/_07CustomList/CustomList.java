package _07CustomList;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> values;

    public CustomList() {
        this.values = new ArrayList<>();
    }

    private boolean validateIndex(int index) {
        return index >= 0 && index < this.values.size();
    }

    private boolean validateTwoIndexes(int firstIndex, int secondIndex) {
        return firstIndex >= 0 && firstIndex < this.values.size()
                && secondIndex >= 0 && secondIndex < this.values.size();
    }

    public void add(T element) {
        this.values.add(element);
    }

    public void remove(int index) {
        if (validateIndex(index)) {
            this.values.remove(index);
        }
    }

    public boolean contains(T element) {
        return this.values.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        if (validateTwoIndexes(firstIndex, secondIndex)) {
            T firstElement = this.values.get(firstIndex);
            T secondElement = this.values.get(secondIndex);
            this.values.set(firstIndex, secondElement);
            this.values.set(secondIndex, firstElement);
        }
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T value : this.values) {
            if (value.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        T max = null;
        for (T value : values) {
            if (max == null || value.compareTo(max) > 0) {
                max = value;
            }
        }
        return max;
    }

    public T getMin() {
        T min = null;
        for (T value : this.values) {
            if (min == null || value.compareTo(min) < 0) {
                min = value;
            }
        }
        return min;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T value : this.values) {
            builder.append(value);
            builder.append(System.lineSeparator());
        }
        return builder.toString();

    }


}
