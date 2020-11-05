/**
 * 栗林健太郎
 * 2030006
 * 2020年11月5日
 */

public class BSLeaf<K extends Comparable<? super K>, V> implements BSTree<K, V> {
    public BSNlTree<K, V> put(K k, V v) {
        return new BSNlTree<K, V>(k, v, this, this);
    }

    public V get(K k) {
        return null;
    }
}
