/**
 * 栗林健太郎
 * 2030006
 * 2020年9月19日
 */

public abstract class AbstractPointPolarCoordinates extends AbstractPoint {
    private double r;
    private double theta;

    public final void setR(double r) {
        this.r = r;
    }

    public final double getR() {
        return r;
    }

    public final void setTheta(double theta) {
        this.theta = theta;
    }

    public final double getTheta() {
        return theta;
    }

    public double distance() {
        return r;
    }

    public PointRectangularCoordinates convertToRectangularCoordinates() {
        return new PointRectangularCoordinates(getX(), getY());
    }
}
