/**
 * A
 */
public class A {
    public void m(A x, A y, A z) {
        System.out.println("A.m(A x, A y, A z)");
    }
    public void m(B x, B y, B z) {
        System.out.println("A.m(B x, B y, B z)");
        // Q1
        // this.m(this, this, this);
        // Q2
        // (new D()).m(x, this, z);
        // Q3
        // (new C()).m(new D(), new D(), new D());
        // Q4
        // (new D()).m(new D(), new D(), new D());
        // Q5
        (new C()).m(new D(), x, z);
    }
    public void m(A x, C y, A z) {
        System.out.println("A.m(A x, C y, A z)");
    }
    public void m(B x, B y, C z) {
        System.out.println("A.m(B x, B y, C z)");
    }
}
