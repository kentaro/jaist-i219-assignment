class SSuperB {
    public void m2(SuperB x, SuperB y) {
        System.out.println("m2(SuperB x, SuperB y) in SSuperB;");
    }

    public void m2(SSuperB x, SSuperB y) {
        System.out.println("m2(SSuperB x, SSuperB y) in SSuperB;");
    }
}
