package _02PointInRectangle;

public class Main {
    public static void main(String[] args) {
        int[] coordinates = Reader.readIntegerArray("\\s+");

        Point A = new Point(coordinates[0],coordinates[1]);
        Point B = new Point(coordinates[2],coordinates[3]);

        Rectangle rectangle = new Rectangle(A,B);

        int count = Reader.readIntegerArray("\\s+")[0];

        while (count -- > 0){
            int[] singlePoint = Reader.readIntegerArray("\\s+");
            Point p = new Point(singlePoint[0],singlePoint[1]);

            boolean isWithin = rectangle.contains(p);

            System.out.println(isWithin);
        }
    }
}
