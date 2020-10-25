public interface BSTree<K extends Comparable<? super K>, V> {
    BSTree<K, V> put(K k, V v);
    V get(K k);
}
