/**
 * D
 */
public class D extends C {
    public void m(A x, A y, A z) {
        System.out.println("D.m(A x, A y, A z)");
    }
    public void m(C x, C y, C z) {
        System.out.println("D.m(C x, C y, C z)");
    }
    public void m(A x, C y, A z) {
        System.out.println("D.m(A x, C y, A z)");
    }
    public void m(B x, B y, C z) {
        System.out.println("D.m(B x, B y, C z)");
    }
}
