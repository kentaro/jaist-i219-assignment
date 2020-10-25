public class PointRectangularCoordinates
    extends AbstractPoint
{
    private double x;
    private double y;

    public PointRectangularCoordinates(double x,double y) {
        this.x = x;
        this.y = y;
    }

    public final double getX() {
        return x;
    }

    public final double getY() {
        return y;
    }

    public final void setX(double x) {
        this.x = x;
    }

    public final void setY(double y) {
        this.y = y;
    }

    public double distance() {
        return Math.sqrt(x*x+y*y);
    }

    public PointPolarCoordinatesRadian
    convertToPointPolarCoordinatesRadian()
        throws PointException
    {
        double r = this.distance();
        double theta = Math.atan2(this.getY(),this.getX());
        return new PointPolarCoordinatesRadian(r,theta);
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}