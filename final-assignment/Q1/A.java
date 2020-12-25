/**
 * A
 */
public class A {
    public void m(A x, A y) {
        System.out.println("A.m(A x, A y)");
    }
    public void m(B x, B y) {
        System.out.println("A.m(B x, B y)");
    }
    public void m(B x, C y) {
        System.out.println("A.m(B x, C y)");
    }
    public void m(C x, B y) {
        System.out.println("A.m(C x, B y)");
    }
}
