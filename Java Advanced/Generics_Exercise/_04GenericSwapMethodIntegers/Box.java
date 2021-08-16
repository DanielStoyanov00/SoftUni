package _04GenericSwapMethodIntegers;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> values;

    public Box(){
        this.values = new ArrayList<>();
    }

    public void add(T element){
        this.values.add(element);
    }

    public boolean validateIndexes(int first, int second){
        return first >= 0 && first < this.values.size()
                && second >= 0 && second < this.values.size();
    }

    public void swap(int firstIndex, int secondIndex){
        if (validateIndexes(firstIndex,secondIndex)){
            T firstElement = this.values.get(firstIndex);
            T secondElement = this.values.get(secondIndex);
            this.values.set(firstIndex, secondElement);
            this.values.set(secondIndex, firstElement);
        }
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (T value : this.values){
            builder.append(String.format("%s: %s", value.getClass().getName(), value));
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }




}
