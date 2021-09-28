
import java.util.*;

public class _10PopulationCenter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Long> population = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> info = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("report")) {
            String[] tokens = input.split("\\|");
            String country = tokens[1];
            String city = tokens[0];
            int people = Integer.parseInt(tokens[2]);

            info.putIfAbsent(country,new LinkedHashMap<>());
            info.get(country).putIfAbsent(city,people);

            population.compute(country, (k,v) ->
                    v == null ? people : population.get(country) + people);

            input = scanner.nextLine();
        }

        population.entrySet()
                .stream()
                .sorted((x1, x2) -> x2.getValue().compareTo(x1.getValue()))
                .forEach(entry -> {
                    System.out.printf("%s (total population: %d)\n", entry.getKey(), entry.getValue());
                    Map<String, Integer> innerMap = info.get(entry.getKey());
                    innerMap.entrySet()
                            .stream().sorted((f,s) -> s.getValue().compareTo(f.getValue()))
                            .forEach(e -> {
                                System.out.printf("=>%s: %d\n", e.getKey(),e.getValue());
                            });
                });
    }
}


