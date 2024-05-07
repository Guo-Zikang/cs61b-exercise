import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArraySet<T> implements Iterable<T> {

    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[10];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(x)) // Don't use "=="
                return true;
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("You can't add null to an ArraySet.");
        }
        if (contains(x)) return;
        items[size] = x;
        size++;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    /**
     * returns an iterator (a.k.a. seer) into ME.
     */
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;

        public ArraySetIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        public T next() {
            T returnItem = items[wizPos];
            wizPos++;
            return returnItem;
        }
    }

    @Override
    public String toString() {
        StringBuilder returnStringBuilder = new StringBuilder("{");
        for (int i = 0; i < size - 1; i++) {
            returnStringBuilder.append(items[i].toString());
            returnStringBuilder.append(", ");
        }
        if (size > 0) returnStringBuilder.append(items[size - 1].toString());
        returnStringBuilder.append("}");
        return returnStringBuilder.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (this.getClass() != other.getClass()) return false;
        ArraySet<T> o = (ArraySet<T>) other;
        if (size != o.size()) return false;
        for (T item: o) {
            if (!this.contains(item)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Set<Integer> javaset = new HashSet<>();
        javaset.add(5);
        javaset.add(15);
        javaset.add(25);

        Iterator<Integer> seer = javaset.iterator();
        while (seer.hasNext()) {
            int i = seer.next();
            System.out.println(i);
        }
        for (int i : javaset) System.out.println(i);

        ArraySet<String> aset = new ArraySet<>();
        //s.add(null);
        aset.add("horse");
        aset.add("fish");
        aset.add("house");
        aset.add("fish");
        //System.out.println(s.contains("horse"));
        //System.out.println(s.size());

        // Iteration test
        Iterator<String> aseer = aset.iterator();
        while (aseer.hasNext()) {
            String i = aseer.next();
            System.out.println(i);
        }
        for (String i : aset) System.out.println(i);
        // toString test
        System.out.println(aset);
        // equals test
        ArraySet<String> aset2 = new ArraySet<>();
        //s.add(null);
        aset2.add("horse");
        aset2.add("fish");
        aset2.add("house");
        aset2.add("fish");
        System.out.println(aset.equals(aset));
        System.out.println(aset.equals(aset2));
        System.out.println(aset.equals("fish"));
        System.out.println(aset.equals(null));
    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}