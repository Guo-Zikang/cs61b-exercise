public class DMSList {
    private IntNode sentinel;
    public DMSList() {
        sentinel = new IntNode(-1000, new lastIntNode());
    }
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode h) {
            item = i;
            next = h;
        }
        public int max() {
            return Math.max(item, next.max());
        }
    }
    public class lastIntNode extends IntNode {
        lastIntNode() {
            super(0, null);
        }
        @Override
        public int max() {
            return 0;
        }
    }
    /* Returns 0 if list is empty. Otherwise, returns the max element. */
    public int max() {
        return sentinel.next.max();
    }
    public void insertFront(int x) { sentinel.next = new IntNode(x, sentinel.next); }
    public static void main(String[] args) {
        DMSList lst = new DMSList();
        lst.insertFront(5);
        lst.insertFront(15);
        lst.insertFront(10);
        System.out.println(lst.max());
    }
}