public class TYIterator extends OHIterator {
    boolean flag = false; //表示"thank u"是否出现过

    public TYIterator(OHRequest queue) {
        super(queue);
    }

    @Override
    public OHRequest next() {
        OHRequest result = super.next();
        if (result != null && result.description.contains("thank u")) {
            result = super.next();
        }
        return result;
    }
}
