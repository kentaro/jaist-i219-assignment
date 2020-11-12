// % java -ea TestAssert
public class TestAssert {
    public static void main(String[] args) {
        Integer m = Integer.valueOf(3);
        Integer n = Integer.valueOf(3);
        assert m == n : "m & n refer to different objects";
    }
}
