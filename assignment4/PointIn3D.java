/**
 * 栗林健太郎
 * 2030006
 * 2020年9月19日
 */

public final class PointIn3D extends Point {
    private double z;

    public PointIn3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public final double getZ() {
        return z;
    }

    public final void setZ(double z) {
        this.z = z;
    }

    public double distance() {
        double disIn2D = super.distance();
        return Math.sqrt(disIn2D * disIn2D + z * z);
    }

    public double distance(PointIn3D pt) {
        double disIn2D = super.distance(pt);
        double tmpz = pt.getZ() - z;
        return Math.sqrt(disIn2D * disIn2D + tmpz * tmpz);
    }

    public String toString() {
        return "(" + getX() + "," + getY() + "," + z + ")";
    }
}
