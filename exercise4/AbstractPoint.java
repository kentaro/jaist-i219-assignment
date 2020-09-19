/**
 * 栗林健太郎
 * 2030006
 * 2020年9月19日
 */

public abstract class AbstractPoint implements PointInterface {
    public abstract double distance();
    public abstract double getX();
    public abstract double getY();

    public double distance(PointInterface pt) {
        double tmpx = this.getX() - pt.getX();
        double tmpy = this.getY() - pt.getY();

        return Math.sqrt(tmpx * tmpx + tmpy * tmpy);
    }
}
