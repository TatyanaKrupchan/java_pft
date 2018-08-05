package src.mathematics;

// import src.mathematics.Point;
import java.text.DecimalFormat;

public class MyFirstMathProgram {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Point p1 = new Point(2, 3);
        Point p2 = new Point(2, 3.022858);

        DecimalFormat df = new DecimalFormat("#0.####");
        // String formattedDistance = df.format(distance(p1, p2));
        String formattedDistance = df.format(p1.distance(p2));
        System.out.println("Distance between 2 points is: " + formattedDistance);
    }

    /*public static double distance(Point p1, Point p2) {
        Double dist;
        return dist = Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    }*/
}