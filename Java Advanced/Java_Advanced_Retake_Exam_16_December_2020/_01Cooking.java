package com.company;
import java.util.*;
import java.util.stream.Collectors;

public class _01Cooking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Deque<Integer> ingredientsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredientsStack::push);

        Map<String, Integer> materials = new TreeMap<>();
        materials.put("Bread", 0);
        materials.put("Cake", 0);
        materials.put("Fruit Pie", 0);
        materials.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() || !ingredientsStack.isEmpty()) {
            if (liquidsQueue.isEmpty() || ingredientsStack.isEmpty()) {
                break;
            }

            int liquid = liquidsQueue.poll();
            int ingredient = ingredientsStack.pop();

            int sum = liquid + ingredient;
            if (sum == 25) {
                materials.put("Bread", materials.get("Bread") + 1);
            } else if (sum == 50) {
                materials.put("Cake", materials.get("Cake") + 1);
            } else if (sum == 75) {
                materials.put("Pastry", materials.get("Pastry") + 1);
            } else if (sum == 100) {
                materials.put("Fruit Pie", materials.get("Fruit Pie") + 1);
            } else {
                ingredientsStack.push(ingredient + 3);
            }
        }

        if (materials.get("Bread") > 0 && materials.get("Cake") > 0 && materials.get("Fruit Pie") > 0 && materials.get("Pastry") > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.printf("Liquids left: %s\n", liquidsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.printf("Ingredients left: %s\n", ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        }
        materials.forEach((key, value) -> System.out.printf("%s: %d\n", key, value));
    }
}
