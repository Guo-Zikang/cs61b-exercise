public class BinarySearchTree<Key extends Comparable<Key>> {

    private class BST {
        private Key key;
        private BST left;
        private BST right;

        public BST(Key key, BST left, BST right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        public BST(Key key) {
            this.key = key;
        }
    }

    BST find(BST T, Key key) {
        if (T == null) {
            return null;
        }
        int cmp = key.compareTo(T.key);
        if (cmp == 0) {
            return T;
        } else if (cmp < 0) {
            return find(T.left, key);
        } else {
            return find(T.right, key);
        }
    }

    BST insert(BST T, Key key) {
        if (T == null) {
            return new BST(key);
        }
        int cmp = key.compareTo(T.key);
        if (cmp < 0) {
            T.left = insert(T.left, key);
        } else if (cmp > 0) {
            T.right = insert(T.right, key);
        }
        return T;
    }
}
