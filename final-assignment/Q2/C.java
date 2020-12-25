/**
 * C
 */
public class C extends B {
    public void m(A x, A y) {
        System.out.println("C.m(A x, A y)");
    }
    // TODO
    public void m(A x, B y) {
        System.out.println("C.m(B x, B y)");
    }
    public void m(B x, A y) {
        System.out.println("C.m(B x, A y)");
    }
    public void m(B x, B y) {
        System.out.println("C.m(B x, B y)");
    }
    public void m(A x, C y) {
        System.out.println("C.m(A x, C y)");
    }
    public void m(C x, A y) {
        System.out.println("C.m(C x, A y)");
    }
    public void m(C x, C y) {
        System.out.println("C.m(C x, C y)");
    }
}
