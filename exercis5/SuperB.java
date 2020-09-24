public class SuperB extends SSuperB {
    public void m1(SuperB x) {
        System.out.println("m1(SuperB x) in SuperB;");
        // AMsgPassing
    }

    public void m2(SubB x, SubB y) {
        System.out.println("m2(SubB x, SubB y) in SuperB;");
    }

    public void m2(SuperB x, SuperB y) {
        System.out.println("m2(SuperB x, SuperB y) in SuperB;");
    }
}
