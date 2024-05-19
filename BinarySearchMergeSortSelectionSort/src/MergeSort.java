public class MergeSort {

    public static String[] mergeSort(String[] sorts) {
        int N = sorts.length;
        if (N <= 1) {
            return sorts;
        }
        int mid = N / 2;
        String[] left = new String[mid];
        String[] right = new String[N - mid];
        System.arraycopy(sorts, 0, left, 0, left.length);
        System.arraycopy(sorts, mid, right, 0, right.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static String[] merge(String[] sortsLeft, String[] sortsRight) {
        String[] sorts = new String[sortsLeft.length + sortsRight.length];
        int i = 0, j = 0;
        for (int k = 0; k < sorts.length; k++) {
            if (i == sortsLeft.length) {
                sorts[k] = sortsRight[j];
                j++;
            } else if (j == sortsRight.length) {
                sorts[k] = sortsLeft[i];
                i++;
            } else if (sortsLeft[i].compareTo(sortsRight[j]) < 0) {
                sorts[k] = sortsLeft[i];
                i++;
            } else {
                sorts[k] = sortsRight[j];
                j++;
            }
        }
        return sorts;
    }
}
