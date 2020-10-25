public class NzNat implements Nat {
    private Nat n;

    public NzNat(Nat y) {
        n = y;
    }

    public Nat pred() {
        return n;
    }

    public NzNat plus(Nat y) {
        return new NzNat(n.plus(y));
    }

    public int compareTo(Nat y) {
        if (y instanceof Zero) {
            return 1;
        } else {
            return n.compareTo(((NzNat) y).pred());
        }
    }
}
