public class Q5 {
    public static void main(String[] args) {
        C c = new C(); B b = c; A a = b;
        System.out.println(c);
        c.m(b, b);
    }
}
