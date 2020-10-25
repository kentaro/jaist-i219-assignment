public class TestPointIn3D {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(3.0));
        PointIn3D p1 = new PointIn3D(1.0,1.0,1.0);
        PointIn3D p2 = new PointIn3D(-1.0,-1.0,-1.0);
        double d;
        d = p1.distance();
        System.out.println("The distance of " + p1 + " is " + d + ".");
        d = p1.distance(p2);
        System.out.println("The distance of " + p1
                           + " & " + p2 + " is " + d + ".");
        p1.setX(1.7320508075688772);
        p1.setY(1.7320508075688772);
        p1.setZ(1.7320508075688772);
        System.out.println("The point moved to " + p1 + ".");
        d = p1.distance();
        System.out.println("The distance is " + d + ".");
    }
}