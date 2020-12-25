/**
 * C
 */
public class C extends B {
    public void m(A x, A y, A z) {
        System.out.println("C.m(A x, A y, A z)");
    }
    public void m(A x, B y, A z) {
        System.out.println("C.m(A x, B y, A z)");
    }
    public void m(B x, A y, B z) {
        System.out.println("C.m(B x, A y, B z)");
    }
    public void m(A x, C y, B z) {
        System.out.println("C.m(A x, C y, B z)");
    }
    public void m(A x, B y, C z) {
        System.out.println("C.m(A x, B y, C z)");
    }
    public void m(C x, A y, B z) {
        System.out.println("C.m(C x, A y, B z)");
    }
    public void m(B x, B y, C z) {
        System.out.println("C.m(B x, B y, C z)");
    }
    public void m(C x, B y, B z) {
        System.out.println("C.m(C x, B y, B z)");
    }
    public void m(B x, C y, B z) {
        System.out.println("C.m(B x, C y, B z)");
    }
}
