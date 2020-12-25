public class Q4 {
    public static void main(String[] args) {
        C c = new C(); B b = c; A a = b;
        System.out.println(a);
        a.m(b, c);
    }
}
