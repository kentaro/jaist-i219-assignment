import java.util.*;

public class BlueClass2 extends ArrayList<KeyValPair> {
    public BlueClass2() {
        super();
    }

    public void put(String k, int v) {
        for (int i = 0; i < super.size(); i++)
            if (k.equals(this.get(i).getKey())) {
                this.get(i).setVal(v);
                return;
            }
        super.add(0,new KeyValPair(k,v));
    }

    public Integer get(String k) {
        for (int i = 0; i < super.size(); i++)
            if (k.equals(this.get(i).getKey()))
                return this.get(i).getVal();
        return null;
    }

    public void delete(String k) {
        for (int i = 0; i < super.size(); i++)
            if (k.equals(this.get(i).getKey())) {
                super.remove(i);
                return;
            }
    }

    public boolean isRegistered(String k) {
        for (int i = 0; i < super.size(); i++)
            if (k.equals(this.get(i).getKey()))
                return true;
        return false;
    }

    public String toString() {
        return super.toString();
    }
}
