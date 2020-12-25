public class Q {
    public static void main(String[] args) {
        A a = new B();
        A b = new C();
        A c = new D();
        D d = new D();
        d.m(d, a, b, c);
    }
}
