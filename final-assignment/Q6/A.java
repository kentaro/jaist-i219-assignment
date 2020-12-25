/**
 * A
 */
public class A {
    public void m(Integer x, A y, A z, Double r) {
        System.out.println("A.m(Integer x, A y, A z, Double r)");
    }
    public void m(Integer x, B y, B z, Double r) {
        System.out.println("A.m(Integer x, B y, B z, Double r)");
    }
    public void m(int x, C y, C z, double r) {
        System.out.println("A.m(int x, C y, C z, double r)");
    }
    public void m(int x, B y, A z, double r) {
        System.out.println("A.m(int x, B y, A z, double r)");
    }
    public void m(int x, A y, B z, double r) {
        System.out.println("A.m(int x, A y, B z, double r)");
    }
}
