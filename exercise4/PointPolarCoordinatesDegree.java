public class PointPolarCoordinatesDegree
    extends AbstractPointPolarCoordinates
{
    public PointPolarCoordinatesDegree(double r, double theta)
        throws PointException
    {
        if (r < 0.0) {
            throw new PointException("r should not be negative!");
        }
        if (theta < 0.0 || theta > 360.0) {
            throw new PointException("theta should satify ineqality: "
                                      + "0.0 <= theta <= "
                                      + 360.0);
        }
        this.setR(r);
        this.setTheta(theta);
    }

    public final double getX() {
        double thetaInRadian
            = (2.0 * Math.PI * this.getTheta()) / 360.0;
        return Math.cos(thetaInRadian) * this.getR();
    }

    public final double getY() {
        double thetaInRadian
            = (2.0 * Math.PI * this.getTheta()) / 360.0;
        return Math.sin(thetaInRadian) * this.getR();
    }

    public String toString() {
        return "<r: " + this.getR() + ","
            + "theta(in degree): " + this.getTheta() + ">";
    }
}