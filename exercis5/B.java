public class B extends SuperB {
    public void m2(SuperB x, SuperB y) {
        System.out.println("m2(SuperB x, SuperB y) in B;");
        super.m2(new B(), new B());
    }

    public void m2(SubB x, SubB y) {
        System.out.println("m2(SubB x, SubB y) in B;");
        super.m2(new B(), new B());
    }

    public void m2(B x, B y) {
        System.out.println("m2(B x, B y) in B;");
        super.m2(new B(), new B());
    }

    public void main(String[] args) {
        (new B()).m1(new B());
    }
}
