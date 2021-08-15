import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class _05FilterByAge {

    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] personInfo = scanner.nextLine().split(", ");
            people.add(new Person(personInfo[0], Integer.parseInt(personInfo[1])));
        }

        String criteria = scanner.nextLine();
        int ageCriteria = Integer.parseInt(scanner.nextLine());

        Predicate<Person> ageFilter = createAgeFilter(criteria, ageCriteria);

        String format = scanner.nextLine();
        Function<Person, String> formatter = createFormatter(format);


        people.stream()
                .filter(ageFilter)
                .map(formatter)
                .forEach(System.out::println);
    }

    private static Function<Person, String> createFormatter(String format) {
        if (format.equals("name")){
            return p -> p.name;
        }else if (format.equals("age")){
            return p -> String.valueOf(p.age);
        }else {
            return p -> String.format("%s - %d", p.name,p.age);
        }

    }

    private static Predicate<Person> createAgeFilter(String criteria, int ageCriteria) {
        if (criteria.equals("older")) {
            return num -> num.age >= ageCriteria;
        }
        return num -> num.age <= ageCriteria;

    }
    }
