import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pos = partition(array, left, right);
            quickSort(array, left, pos - 1);
            quickSort(array, pos + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        while (left < right) {
            while (left < right && array[right] >= pivot) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= pivot) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] array = {5, 9, 1, 3, 7, 0, 2, 4, 2, 1, 10, 1, 9, 8, 6};
        QuickSort.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
