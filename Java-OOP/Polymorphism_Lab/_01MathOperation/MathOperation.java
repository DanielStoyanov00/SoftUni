package _01MathOperation;

public class MathOperation {

    public static int add(int first, int second){
        return first + second;
    }

    public static int add(int first, int second, int third){
        return add(first,second) + third;
    }

    public static int add(int first, int second, int third, int fourth){
        return add(first, second, third) + fourth;
    }
}
