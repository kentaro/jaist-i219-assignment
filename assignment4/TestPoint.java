public class TestPoint {
    public static void main(String[] args) {
        Point p0 = new Point();
        Point p1 = new Point(1.4142135623730951,1.4142135623730951);
        System.out.println("p0: " + p0);
        p0.setX(1.0);
        p0.setY(1.0);
        System.out.println("p0: " + p0);
        System.out.println("p1: " + p1);
        System.out.println("x1: " + p1.getX());
        System.out.println("y1: " + p1.getY());
        System.out.println("d0: " + p0.distance());
        System.out.println("d1: " + p1.distance());
        System.out.println("#points made: " + Point.howManyPoints());
    }
}
