/**
 * B
 */
public class B extends A {
    public void m(A x, A y, A z) {
        System.out.println("B.m(A x, A y, A z)");
    }
    public void m(A x, C y, A z) {
        System.out.println("B.m(A x, C y, A z)");
    }
    public void m(A x, B y, A z) {
        System.out.println("B.m(A x, B y, A z)");
    }
    public void m(C x, B y, A z) {
        System.out.println("B.m(C x, B y, A z)");
        // Q1
        // this.m(this, this, this);
        // Q2
        // x.m(x, x, x);
        // Q3
        // (new D()).m(x, x, x);
        // Q4
        // x.m(z, this, z);
        // Q5
        this.m(z, this, z);
        
    }
    public void m(B x, B y, C z) {
        System.out.println("B.m(B x, B y, C z)");
    }
}
