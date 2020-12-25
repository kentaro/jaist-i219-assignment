/**
 * C
 */
public class C extends B {
    public void m(A x, A y, A z, A r) {
        System.out.println("C.m(A x, A y, A z, A r)");
    }
    public void m(A x, B y, C z, D r) {
        System.out.println("C.m(A x, B y, C z, D r)");
    }
    public void m(D x, B y, C z, D r) {
        System.out.println("C.m(D x, B y, C z, D r)");
    }
    public void m(D x, A y, B z, A r) {
        System.out.println("C.m(D x, A y, B z, A r)");
    }
    public void m(B x, A y, C z, D r) {
        System.out.println("C.m(B x, A y, C z, D r)");
    }
    public void m(D x, A y, C z, C r) {
        System.out.println("C.m(D x, A y, C z, C r)");
    }
    public void m(B x, B y, C z, D r) {
        System.out.println("C.m(B x, B y, C z, D r)");
    }
    public void m(B x, A y, B z, A r) {
        System.out.println("C.m(B x, A y, B z, A r)");
    }
    public void m(A x, B y, A z, A r) {
        System.out.println("C.m(A x, B y, A z, A r)");
    }
}
