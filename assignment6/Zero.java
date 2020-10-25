public class Zero implements Nat {
    public Nat plus(Nat y) {
        return y;
    }

    public int compareTo(Nat y) {
        if (y instanceof Zero) {
            return 0;
        } else {
            return -1;
        }
    }
}
