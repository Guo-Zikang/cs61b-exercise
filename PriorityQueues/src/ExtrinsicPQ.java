/**
 * Priority queue where objects have no intrinsic priority. Instead,
 * priorities are supplied as an argument during insertion and can be
 * changed.
 */
public interface ExtrinsicPQ<T> {
    /* Inserts an item with the given priority value. This is also known as "enqueue", or "offer". */
    void insert(T item, double priority);

    /* Returns the minimum item. Also known as "min". */
    T peek();

    /* Removes and returns the minimum item. Also known as "dequeue". */
    T removeMin();

    /* Changes the priority of the given item. The behavior if the item doesn't exist is undefined. */
    void changePriority(T item, double priority);

    /* Returns the number of items in the PQ. */
    int size();
}
