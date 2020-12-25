/**
 * D
 */
public class D extends C {
    public void m(Integer x, A y, A z, Double r) {
        System.out.println("D.m(Integer x, A y, A z, Double r)");
    }
    public void m(Integer x, C y, B z, Double r) {
        System.out.println("D.m(Integer x, C y, B z, Double r)");
    }
    public void m(int x, A y, D z, double r) {
        System.out.println("D.m(int x, A y, D z, double r)");
    }
}
