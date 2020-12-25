/**
 * B
 */
public class B extends A {
    public void m(A x, A y, A z, A r) {
        System.out.println("B.m(A x, A y, A z, A r)");
    }
    public void m(A x, B y, C z, D r) {
        System.out.println("B.m(A x, B y, C z, D r)");
    }
    public void m(A x, B y, A z, B r) {
        System.out.println("B.m(A x, B y, A z, B r)");
    }
    public void m(A x, B y, B z, A r) {
        System.out.println("B.m(A x, B y, B z, A r)");
    }
    public void m(B x, A y, B z, A r) {
        System.out.println("B.m(B x, A y, B z, A r)");
    }
    public void m(D x, A y, A z, C r) {
        System.out.println("B.m(D x, A y, A z, C r)");
    }
    public void m(A x, A y, B z, A r) {
        System.out.println("B.m(A x, A y, B z, A r)");
    }
}
