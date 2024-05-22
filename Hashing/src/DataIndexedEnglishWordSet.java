public class DataIndexedEnglishWordSet {

    private boolean[] present;

    public DataIndexedEnglishWordSet() {
        present = new boolean[1000];
    }

    public void add(String s) {
        present[englishToInt(s)] = true;
    }

    public boolean contains(String s) {
        return present[englishToInt(s)];
    }

    public static int letterNum(String s, int i) {
        char ithChar = s.charAt(i);
        if (ithChar < 'a' || ithChar > 'z') {
            throw new IllegalArgumentException();
        }
        return ithChar - 'a' + 1;
    }

    public static int englishToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum * 26;
            sum += letterNum(s, i);
        }
        return sum;
    }
}
