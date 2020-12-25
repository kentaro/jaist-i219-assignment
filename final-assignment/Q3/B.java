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
    }
    public void m(B x, B y, C z) {
        System.out.println("B.m(B x, B y, C z)");
    }
}
