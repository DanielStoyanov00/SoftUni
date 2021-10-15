package _03GenericScale;

public class Main {
    public static void main(String[] args) {


        Scale<Integer> scale1 = new Scale<>(16, 16);
        Scale<Integer> scale2 = new Scale<>(17, 16);
        Scale<Integer> scale3 = new Scale<>(15, 16);

        Integer heavier1 = scale1.getHeavier(); // null
        Integer heavier2 = scale2.getHeavier(); // 17
        Integer heavier3 = scale3.getHeavier(); // 16
    }
}
