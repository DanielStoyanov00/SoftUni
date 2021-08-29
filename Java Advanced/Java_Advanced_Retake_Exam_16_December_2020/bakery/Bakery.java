package bakery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bakery {
    public String name;
    public int capacity;
    public List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.capacity > this.employees.size()) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                this.employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        return this.employees.stream().sorted((a, b) -> Integer.compare(b.getAge(), a.getAge())).collect(Collectors.toList()).get(0);
    }

    public Employee getEmployee(String name) {
        return this.employees.stream().filter(emp -> emp.getName().equals(name)).collect(Collectors.toList()).get(0);
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s:", this.name)).append(System.lineSeparator());
        for (int i = 0; i < this.employees.size(); i++) {
            if (i == this.employees.size() - 1) {
                sb.append(this.employees.get(i));
            } else {
                sb.append(this.employees.get(i)).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

}
