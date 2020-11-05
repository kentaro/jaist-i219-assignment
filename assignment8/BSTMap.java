/**
 * 栗林健太郎
 * 2030006
 * 2020年11月5日
 */

public class BSTMap<K extends Comparable<? super K>, V> implements MapInterface<K, V> {
    private BSTree<K, V> bst;

    public BSTMap() {
        bst = new BSLeaf<K, V>();
    }

    public void put(K k, V v) {
        bst = bst.put(k, v);
    }

    public V get(K k) {
        return bst.get(k);
    }
}
