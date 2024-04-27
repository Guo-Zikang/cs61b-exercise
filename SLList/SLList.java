public class SLList<Item> implements List61B<Item> {
    public class Node {
        public Item item;
        public Node next;

        public Node(Item i, Node n) {
            item = i;
            next = n;
        }
    }

    /*The first item (if it exists) is at sentinal.next. */
    private Node sentinal;
    private int size;

    public SLList() {
        sentinal = new Node(null, null);
    }

    public SLList(Item x) {
        sentinal = new Node(null, null);
        sentinal.next = new Node(x, null);
        size = 1;
    }

    public void addFirst(Item x) {
        sentinal.next = new Node(x, sentinal.next);
        size++;
    }

    public Item getFirst() {
        return sentinal.next.item;
    }

    public void addLast(Item x) {
        Node p = sentinal;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(x, null);
        size++;
    }

    public Item getLast() {
        Node p = sentinal;
        while (p.next != null) {
            p = p.next;
        }
        return p.item;
    }

    public Item removeLast() {
        if (sentinal.next == null) return null;
        Node p = sentinal;
        Node back = p.next;
        while (back.next != null) {
            p = p.next;
            back = back.next;
        }
        p.next = null;
        size -= 1;
        return back.item;
    }

    /** Returns the ith item in the list. */
    public Item get(int i) {
        Node p = sentinal.next;
        while (p != null && i > 0) {
            p = p.next;
            i--;
        }
        if (p == null) return null;
        return p.item;
    }

    /** Inserts the item into the given position in
     *  the list. If position is greater than the
     *  size of the list, inserts at the end instead.
     */
    public void insert(Item x, int position) {
        Node p = sentinal;
        while (position > 1 && p.next != null) {
            p = p.next;
            position--;
        }
        p.next = new Node(x, p.next);
        size++;
    }

    public int size() {
        return size;
    }

    @Override
    public void print() {
        for (Node p = sentinal.next; p != null; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SLList<Integer> L = new SLList<>(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        L.insert(18, 4);
        L.print();
        System.out.println(L.size());
        L.removeLast();
        L.print();
        System.out.println(L.size());
        L.removeLast();
        L.print();
        System.out.println(L.size());
    }
}