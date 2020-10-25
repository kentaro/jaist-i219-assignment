/**
 * 栗林健太郎
 * 2030006
 * 2020年10月25日
 */

public class TBSLeaf<K extends Comparable<K>, V> implements TBSTree<K, V> {
    public TBSNlTree<K, V> put(K k, V v) {
        return new TBSNlTree<K, V>(k, v, this, this);
    }

    public V get(K k) {
        return null;
    }
}
