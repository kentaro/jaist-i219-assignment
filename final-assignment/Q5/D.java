/**
 * D
 */
public class D extends C {
    public void m(A x, A y, A z, A r) {
        System.out.println("D.m(A x, A y, A z, Ar)");
    }
    public void m(A x, B y, C z, D r) {
        System.out.println("D.m(A x, B y, C z, D r)");
    }
    public void m(D x, C y, B z, D r) {
        System.out.println("D.m(D x, C y, B z, D r)");
    }
    public void m(D x, B y, C z, D r) {
        System.out.println("D.m(D x, B y, C z, D r)");
    }
}
