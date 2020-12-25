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
    }
}
