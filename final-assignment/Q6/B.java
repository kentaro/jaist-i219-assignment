/**
 * B
 */
public class B extends A {
    public void m(Integer x, A y, A z, Double r) {
        System.out.println("B.m(Integer x, A y, A z, Double r)");
    }
    public void m(Integer x, C y, C z, double r) {
        System.out.println("B.m(Integer x, C y, C z, double r)");
    }
    public void m(int x, B y, C z, double r) {
        System.out.println("B.m(int x, B y, C z, double r)");
    }
    public void m(int x, C y, D z, Double r) {
        System.out.println("B.m(int x, C y, D z, Double r)");
        // Q1
        // z.m(2, y, y, 3.14);
        // Q2
        // z.m(2, new B(), new B(), r);
        // Q3
        // this.m(2, new A(), new A(), 3.14);
        // Q4
        // z.m(new Integer(2), new B(), new B(), r);
        // Q5
        y.m(new Integer(2), new A(), z, r);
    }
    public void m(Integer x, B y, B z, double r) {
        System.out.println("B.m(Integer x, B y, B z, double r)");
    }
    public void m(int x, A y, B z, double r) {
        System.out.println("B.m(int x, A y, B z, double r)");
    }
    public void m(int x, A y, C z, double r) {
        System.out.println("B.m(int x, A y, C z, double r)");
    }
}
