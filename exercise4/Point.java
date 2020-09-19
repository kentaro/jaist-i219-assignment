/**
 * 栗林健太郎
 * 2030006
 * 2020年9月19日
 */

public class Point {
    private double x = -0.5;
    private double y;
    private static int n = 0;

    public Point() {
        n++;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        n++;
    }

    public final double getX() {
        return x;
    }

    public final void setX(double x) {
        this.x = x;
    }

    public final double getY() {
        return y;
    }

    public final void setY(double y) {
        this.y = y;
    }

    public double distance() {
        return Math.sqrt(x * x + y * y);
    }

    public double distance(Point pt) {
        double tmpx = pt.getX() - x;
        double tmpy = pt.getY() - y;
        return Math.sqrt(tmpx * tmpx + tmpy * tmpy);
    }

    public void move(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public static int howManyPoints() {
        return n;
    }
}
