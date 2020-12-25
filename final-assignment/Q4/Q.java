public class Q {
    public static void main(String[] args) {
        A a = new B();
        B b = new C();
        C c = new D();
        D d = new D();
        d.m(c, b, a);
    }
}
