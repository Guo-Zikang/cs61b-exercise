public class BinarySearch {

    public static int binarySearch(String[] sorts, String x) {
        return binarySearchHelper(sorts, x, 0, sorts.length);
    }

    private static int binarySearchHelper(String[] sorts, String x, int low, int high) {
        if (high < low) return -1;
        int mid = (low + high) / 2;
        int com = x.compareTo(sorts[mid]);
        if (com < 0) {
            return binarySearchHelper(sorts, x, low, mid - 1);
        } else if (com > 0) {
            return binarySearchHelper(sorts, x, mid + 1, high);
        } else {
            return mid;
        }
    }
}
