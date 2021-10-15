import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class _02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Consumer<List<String>> namesPlusSir = name -> name.forEach( e -> System.out.println("Sir " + e));
        namesPlusSir.accept(names);
    }
}
