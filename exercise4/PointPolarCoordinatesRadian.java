class PointPolarCoordinatesRadian extends AbstractPointPolarCoordinates {
    public PointPolarCoordinatesRadian(double r, double theta) throws PointException {
        if (r < 0.0) {
            throw new PointException("r should not be negative!");
        }
        if (theta < 0.0 || theta > 2.0 * Math.PI) {
            throw new PointException("theta should satify ineqality: "
                                      + "0.0 <= theta <= "
                                      + 2.0);
        }
        this.setR(r);
        this.setTheta(theta);
    }

    public final double getX() {
        return Math.cos(this.getTheta()) * this.getR();
    }

    public final double getY() {
        return Math.sin(this.getTheta()) * this.getR();
    }

    public String toString() {
        return "<r: " + this.getR() + ","
            + "theta(in radian): " + this.getTheta() + ">";
    }
}
