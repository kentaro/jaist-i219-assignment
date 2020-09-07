public class BlueClassUndo2 extends BlueClass2 {
    private String prevKey;
    private Integer prevVal;

    public BlueClassUndo2() {
        super();
        prevKey = null;
        prevVal = null;
    }

    public void put(String k, int v) {
        prevKey = k;
        if (super.isRegistered(k)) {
            prevVal = super.get(k);
        } else {
            prevVal = null;
        }
        super.put(k,v);
    }

    public void undo() {
        if (prevKey != null) {
            if (prevVal != null) {
                super.put(prevKey,prevVal);
                prevVal = null;
            } else {
                super.delete(prevKey);
            }
            prevKey = null;
        }
    }
}