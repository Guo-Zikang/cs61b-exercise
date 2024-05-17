import java.util.*;
import java.util.function.Predicate;

public class FilterList<T> implements Iterable<T> {

    List<T> lst;
    Predicate<T> filter;
    public FilterList (List<T> L, Predicate<T> filter) {
        lst = L;
        this.filter = filter;
    }

    @Override
    public Iterator<T> iterator() {
        return new FilterListIterator();
    }

    private class FilterListIterator implements Iterator<T> {
        int index;

        public FilterListIterator() {
            index = 0;
            moveIndex();
        }

        @Override
        public boolean hasNext() {
            return index < lst.size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T value = lst.get(index);
            index++;
            moveIndex();
            return value;
        }

        private void moveIndex() {
            while (hasNext() && !filter.test(lst.get(index))) {
                index++;
            }
        }
    }
}
