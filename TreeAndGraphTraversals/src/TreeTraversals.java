public class TreeTraversals <K extends Comparable<K>, V>{

    private BSTNode root;

    private class BSTNode {
        private K key;
        private V value;
        private BSTNode left;
        private BSTNode right;

        BSTNode(K key, V value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public TreeTraversals() {}

    public void preOrder(BSTNode x) {
        if (x == null) return;
        System.out.println(x.key);
        preOrder(x.left);
        preOrder(x.right);
    }

    public void inOrder(BSTNode x) {
        if (x == null) return;
        preOrder(x.left);
        System.out.println(x.key);
        preOrder(x.right);
    }

    public void postOrder(BSTNode x) {
        if (x == null) return;
        preOrder(x.left);
        preOrder(x.right);
        System.out.println(x.key);
    }
}
