public interface TBSTree<K extends Comparable<K>, V> {
    TBSTree<K, V> put(K k, V v);
    V get(K k);
}
