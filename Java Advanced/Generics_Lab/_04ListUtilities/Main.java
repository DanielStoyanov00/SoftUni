package _04ListUtilities;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        integers.add(55);
        integers.add(13);
        integers.add(32);
        integers.add(44);

        System.out.println(ListUtils.getMax(integers)); // 55
        System.out.println(ListUtils.getMin(integers)); // 13

        List<String> names = new ArrayList<>();
        names.add("Pesho");
        names.add("Gosho");
        names.add("Niki");
        names.add("Tosho");

        System.out.println(ListUtils.getMax(names)); // Tosho
        System.out.println(ListUtils.getMin(names)); // Gosho
    }
}
