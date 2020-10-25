public class BSLeaf<K extends Comparable<? super K>, V> implements BSTree<K, V> {
    public BSNlTree<K, V> put(K k, V v) {
        return new BSNlTree<K, V>(k, v, this, this);
    }

    public V get(K k) {
        return null;
    }
}
