public class VengefulSLList<Item> extends SLList<Item> {
    SLList<Item> deletedItems;

    VengefulSLList() {
        deletedItems = new SLList<>();
    }

    VengefulSLList(Item x) {
        super(x);
        deletedItems = new SLList<>();
    }

    @Override
    public Item removeLast() {
        Item removedItem = super.removeLast();
        deletedItems.addLast(removedItem);
        return removedItem;
    }

    public void printLostItems() {
        deletedItems.print();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> L = new VengefulSLList<>();
        L.addFirst(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        L.insert(18, 4);
        L.removeLast();
        L.removeLast();
        L.printLostItems();
    }
}
