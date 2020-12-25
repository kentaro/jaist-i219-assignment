/**
 * A
 */
public class A {
    public void m(A x, A y, A z) {
        System.out.println("A.m(A x, A y, A z)");
    }
    public void m(B x, B y, B z) {
        System.out.println("A.m(B x, B y, B z)");
    }
    public void m(A x, C y, A z) {
        System.out.println("A.m(A x, C y, A z)");
    }
    public void m(B x, B y, C z) {
        System.out.println("A.m(B x, B y, C z)");
    }
}
