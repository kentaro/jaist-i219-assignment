/**
 * A
 */
public class A {
    public void m(A x, A y, A z, A r) {
        System.out.println("A.m(A x, A y, A z, A r)");
    }
    public void m(A x, B y, C z, D r) {
        System.out.println("A.m(A x, B y, C z, D r)");
    }
    public void m(D x, B y, C z, D r) {
        System.out.println("A.m(D x, B y, C z, D r)");
    }
    public void m(A x, B y, A z, A r) {
        System.out.println("A.m(A x, B y, A z, A r)");
    }
    public void m(A x, A y, B z, A r) {
        System.out.println("A.m(A x, A y, B z, A r)");
    }
    public void m(D x, A y, A z, A r) {
        System.out.println("A.m(D x, A y, A z, A r)");
        // Q1
        // this.m(this, this, this, this);
        // Q2
        // this.m(new D(), new B(), new D(), new D());
        // Q3
        // r.m(new A(), new B(), x, x);
        // Q4
        // x.m(x, x, x, x);
        // Q5
        x.m(x, new C(), new B(), x);
    }
    public void m(A x, A y, A z, C r) {
        System.out.println("A.m(A x, A y, A z, C r)");
    }
}
