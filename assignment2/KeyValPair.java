public class KeyValPair {
    private String key;
    private int val;

    public KeyValPair(String k, int v) {
        key = k;
        val = v;
    }

    public String getKey() {
        return key;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int v) {
        val = v;
    }

    public String toString() {
        return "<" + key + "," + val + ">";
    }
}