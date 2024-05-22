public class DataIndexedIntegerSet {

    private boolean[] present;

    public DataIndexedIntegerSet() {
        present = new boolean[1000];
    }

    public void add(int x) {
        present[x] = true;
    }

    public boolean contains(int x) {
        return present[x];
    }
}
