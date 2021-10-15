package _02SalaryIncrease;

public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public void increaseSalary(double bonus){
        if (this.getAge() > 30){
            this.setSalary(this.getSalary() + (this.getSalary() * bonus / 100));
        }else {
            this.setSalary(this.getSalary() + (this.getSalary() * bonus / 200));
        }
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
        return String.format("%s %s gets %f leva", firstName,lastName,salary);
    }
}
