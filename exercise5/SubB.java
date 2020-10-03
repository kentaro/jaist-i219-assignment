public class SubB extends B {
    public void m2(SuperB x, SuperB y) {
        System.out.println("m2(SuperB x, SuperB y) in SubB;");
        super.m2(x, y);
    }

    public void m2(SubB x, SubB y) {
        System.out.println("m2(SubB x, SubB y) in SubB;");
        super.m2(x, y);
    }

    public void m2(B x, B y) {
        System.out.println("m2(B x, B y) in SubB;");
        super.m2(x, y);
    }

    public static void main(String[] args) {
        (new SubB()).m1(new B());
    }
}
