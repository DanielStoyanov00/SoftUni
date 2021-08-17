import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Predicate<String> predicate;

        String input = scanner.nextLine();
        while (!input.equals("Party!")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String criteria = tokens[1];
            List<String> duplicate;
            switch (command) {
                case "Remove":
                    switch (criteria) {
                        case "StartsWith":
                            char startLetter = tokens[2].charAt(0);
                            predicate = word -> word.charAt(0) != startLetter;
                            people = people.stream().filter(predicate).collect(Collectors.toList());
                            break;
                        case "EndsWith":
                            char endLetter = tokens[2].charAt(0);
                            predicate = word -> word.charAt(word.length() - 1) != endLetter;
                            people = people.stream().filter(predicate).collect(Collectors.toList());
                            break;
                        case "Length":
                            int length = Integer.parseInt(tokens[2]);
                            predicate = word -> word.length() != length;
                            people = people.stream().filter(predicate).collect(Collectors.toList());
                            break;
                    }
                    break;
                case "Double":
                    switch (criteria) {
                        case "StartsWith":
                            String startsWith = tokens[2];
                            predicate = name -> name.substring(0, startsWith.length()).equals(startsWith);
                            duplicate = people.stream().filter(predicate).collect(Collectors.toList());
                            people.addAll(duplicate);
                            break;
                        case "EndsWith":
                            String endsWith = tokens[2];
                            predicate = name -> name.substring(name.length() - endsWith.length()).equals(endsWith);
                            duplicate = people.stream().filter(predicate).collect(Collectors.toList());
                            people.addAll(duplicate);
                            break;
                        case "Length":
                            int length = Integer.parseInt(tokens[2]);
                            predicate = name -> name.length() == length;
                            duplicate = people.stream().filter(predicate).collect(Collectors.toList());
                            people.addAll(duplicate);
                            break;
                    }
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
        }

        if (people.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            StringBuilder sb = new StringBuilder();
            people.stream()
                    .sorted()
                    .forEach(name -> {
                        sb.append(name + ", ");
                    });
            sb.deleteCharAt(sb.length() - 2);
            System.out.print(sb);
            System.out.print("are going to the party!");
        }
    }
}
