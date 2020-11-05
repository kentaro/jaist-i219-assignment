/**
 * 栗林健太郎
 * 2030006
 * 2020年11月5日
 */

public class ListMap<K, V> implements MapInterface<K, V> {
    private class MyEntry<K1, V1> {
        private K1 k1;
        private V1 v1;

        public MyEntry(K1 k1, V1 v1) {
            this.k1 = k1;
            this.v1 = v1;
        }

        public K1 getK1() {
            return k1;
        }

        public V1 getV1() {
            return v1;
        }

        public void setK1(K1 k1) {
            this.k1 = k1;
        }

        public void setV1(V1 v1) {
            this.v1 = v1;
        }
    }

    private GList<MyEntry<K, V>> list;

    public ListMap() {
        list = new GNil<MyEntry<K, V>>();
    }

    public void put(K k, V v) {
        MyEntry<K, V> e = this.findEntry(k);
        if (e == null) {
            list = new GNnList<MyEntry<K, V>>(new MyEntry<K, V>(k, v), list);
        } else {
            e.setV1(v);
        }
    }

    public V get(K k ) {
        MyEntry<K, V> e = this.findEntry(k);
        return e == null ? null : e.getV1();
    }

    private MyEntry<K, V> findEntry(K k) {
        for (
            GList<MyEntry<K, V>> l = list;
            !(l instanceof GNil);
            l = ((GNnList<MyEntry<K, V>>) l).getTail()
        ) {
            MyEntry<K, V> e = ((GNnList<MyEntry<K, V>>) l).getHead();
            if (k.equals(e.getK1())) {
                return e;
            }
        }
        return null;
    }
}
