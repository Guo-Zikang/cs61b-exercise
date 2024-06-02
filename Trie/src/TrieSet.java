public class TrieSet {
    private static final int R = 128;
    private Node root;

    private static class Node {
        private boolean isKey;
        private DataIndexedCharMap<Node> next;

        private Node(boolean blue, int R) {
            isKey = blue;
            next = new DataIndexedCharMap<>(R);
        }
    }
}
