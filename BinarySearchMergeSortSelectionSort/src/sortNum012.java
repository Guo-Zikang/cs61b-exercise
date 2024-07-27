public class sortNum012 {
    /**
     * Given an array that only contains 0s, 1s and 2s,
     * write an algorithm to sort it in linear time.
     */
    public static int[] specialSort(int[] arr) {
        int front = 0;
        int back = arr.length - 1;
        int curr = 0;
        while (curr <= back) {
            if (arr[curr] == 0) {
                swap(arr, curr, front);
                front++;
                curr++;
            } else if (arr[curr] == 2) {
                swap(arr, curr, back);
                back--;
            } else {
                curr++;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
