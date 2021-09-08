package _06Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender){
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {
        if (!name.trim().isEmpty()){
            this.name = name;
        }else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    private void setAge(int age) {
        if (age != ' ' && age > 0){
            this.age = age;
        }else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    private void setGender(String gender) {
        if (!gender.trim().isEmpty()){
            this.gender = gender;
        }else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public String produceSound(){
        return "sound";
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(System.lineSeparator());
        sb.append(String.format("%s %d %s", name,age,gender)).append(System.lineSeparator());
        sb.append(produceSound());
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
