package _01JarOfT;


public class Main {
    public static void main(String[] args) {

        Jar<String> firstJar = new Jar<>();
        Jar<Integer> secondJar = new Jar<>();

        firstJar.add("some text");
        firstJar.add("word");
        secondJar.add(5);
        secondJar.add(55);

        System.out.println(firstJar.remove());
        System.out.println(firstJar.remove());
        System.out.println(secondJar.remove());
        System.out.println(secondJar.remove());

    }
}
