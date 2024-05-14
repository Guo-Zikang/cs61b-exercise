import java.util.Iterator;
import java.util.NoSuchElementException;

public class OHIterator implements Iterator<OHRequest> {
    OHRequest curr;

    public OHIterator(OHRequest queue) {
        curr = queue;
    }

    @Override
    public boolean hasNext() {
        while (curr != null) {
            if (isGood(curr.description)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public OHRequest next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        OHRequest re = curr;
        curr = curr.next;
        return re;
    }

    public boolean isGood(String description) {
        return description != null && description.length() > 5;
    }
}
