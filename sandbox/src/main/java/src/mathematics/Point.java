package src.mathematics;

public class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point newP) {
        Double dist;
        return dist = Math.sqrt((newP.x - this.x) * (newP.x - this.x) + (newP.y - this.y) * (newP.y - this.y));
    }
}
