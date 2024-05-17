import java.util.*;

public class IteratorOfIterators implements Iterator<Integer> {
    List<Iterator<Integer>> lst;
    int index;

    public IteratorOfIterators(List<Iterator<Integer>> a) {
        lst = a;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        int indexLast = index;
        while (true) {
            if (lst.get(index).hasNext()) {
                return true;
            }
            index = (index + 1) % lst.size();
            if (index == indexLast) {
                return false;
            }
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer num = lst.get(index).next();
        index = (index + 1) % lst.size();
        return num;
    }
}
