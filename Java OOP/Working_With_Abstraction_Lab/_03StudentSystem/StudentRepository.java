package _03StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository {
    private Map<String, Student> studentsByName;

    public StudentRepository(){
        this.studentsByName = new HashMap<>();
    }

    public void add(Student student) {
        if (!this.studentsByName.containsKey(student.getName())){
        this.studentsByName.put(student.getName(), student);
        }
    }

    public Student get(String name) {
        return this.studentsByName.get(name);
    }
}
