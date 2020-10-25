/**
 * 栗林健太郎
 * 2030006
 * 2020年10月25日
 */

public class BinarySearchTree<K extends Comparable<? super K>, V> {
    private BSTree<K, V> bst;

    public BinarySearchTree() {
        bst = new BSLeaf<K, V>();
    }

    public void put(K k, V v) {
        bst = bst.put(k, v);
    }

    public V get(K k) {
        return bst.get(k);
    }
}
