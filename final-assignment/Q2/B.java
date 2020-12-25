/**
 * B
 */
public class B extends A {
    public void m(A x, A y) {
        System.out.println("B.m(A x, A y)");
    }
    public void m(A x, B y) {
        System.out.println("B.m(B x, B y)");
    }
    public void m(B x, A y) {
        System.out.println("B.m(B x, A y)");
    }
    public void m(B x, B y) {
        System.out.println("B.m(B x, B y)");
    }
    public void m(B x, C y) {
        System.out.println("B.m(B x, C y)");
    }
    public void m(C x, B y) {
        System.out.println("B.m(C x, B y)");
        // Q1
        // x.m(x, x);
        // Q2
        // this.m(this, this);
        // Q3
        // this.m(x, x);
        // Q4
        // y.m(x, x);
        // Q5
        y.m(this, this);
    }
}
