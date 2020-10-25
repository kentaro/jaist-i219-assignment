/**
 * 栗林健太郎
 * 2030006
 * 2020年10月25日
 */

public class TentativeBinarySearchTree<K extends Comparable<K>, V> {
    private TBSTree<K, V> bst;

    public TentativeBinarySearchTree() {
        bst = new TBSLeaf<K, V>();
    }

    public void put(K k, V v) {
        bst = bst.put(k, v);
    }

    public V get(K k) {
        return bst.get(k);
    }
}
