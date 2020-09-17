public class TestPoint2 {
    public static void main(String[] args)
        throws PointException
    {
        PointPolarCoordinatesRadian p1
            = new PointPolarCoordinatesRadian(Math.sqrt(2.0),Math.PI/4.0);
        PointRectangularCoordinates p2
            = new PointRectangularCoordinates(2.0,1.0);
        System.out.println("p1(x,y): "
                           + p1.convertToRectangularCoordinates());
        System.out.println("p2(x,y): " + p2);
        System.out.println("p1(r,theta): " + p1);
        System.out.println("p2(r,theta): "
                           + p2.convertToPointPolarCoordinatesRadian());
        System.out.println("p1->p2: " + p1.distance(p2));
        System.out.println("p2->p1: " + p2.distance(p1));
        try {
            new PointPolarCoordinatesRadian(-1.0,Math.PI/4.0);
        } catch(PointException e) {
            System.err.println(e);
        }
        try {
            new PointPolarCoordinatesRadian(1.0,-1.0);
        } catch(PointException e) {
            System.err.println(e);
        }
    }
}
