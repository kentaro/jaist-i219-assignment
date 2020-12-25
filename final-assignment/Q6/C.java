/**
 * C
 */
public class C extends B {
    public void m(Integer x, A y, A z, Double r) {
        System.out.println("C.m(Integer x, A y, A z, Double r)");
    }
    public void m(Integer x, A y, D z, Double r) {
        System.out.println("C.m(Integer x, A y, D z, Double r)");
    }
    public void m(int x, C y, C z, double r) {
        System.out.println("C.m(int x, C y, C z, double r)");
    }
    public void m(Integer x, B y, C z, double r) {
        System.out.println("C.m(Integer x, B y, C z, double r)");
    }
    public void m(int x, A y, B z, double r) {
        System.out.println("C.m(int x, A y, B z, double r)");
    }
    public void m(int x, A y, C z, double r) {
        System.out.println("C.m(int x, A y, C z, double r)");
    }
}
