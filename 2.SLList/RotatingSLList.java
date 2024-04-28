public class RotatingSLList<Item> extends SLList<Item> {
    public void rotateRight() {
        Item item = removeLast();
        addFirst(item);
    }
}
