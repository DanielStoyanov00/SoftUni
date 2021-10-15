package _03StudentSystem;

public class CommandHandler {
    private final StudentRepository repository;

    public CommandHandler() {
        this.repository = new StudentRepository();
    }

    public String handleCommand(String[] tokens) {
        if (tokens[0].equals("Create")) {
            String name = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            double grade = Double.parseDouble(tokens[3]);
            Student student = new Student(name, age, grade);
            repository.add(student);
            return null;
        } else if (tokens[0].equals("Show")) {
            String name = tokens[1];
            if (repository.get(name) != null) {
                return repository.get(name).getInfo();
            }else {
                return null;
            }
        }
        return tokens[0];
    }
}
