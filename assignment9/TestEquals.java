public class TestEquals {
    public static void main(String[] args) {
        Integer m = Integer.valueOf(3);
        Integer n = Integer.valueOf(3);
        System.out.println("m==n: " + (m == n));
        System.out.println("m.equals(n): " + m.equals(n));
    }
}
