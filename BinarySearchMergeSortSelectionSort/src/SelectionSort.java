public class SelectionSort {

    public static void selectionSort(String[] sorts) {
        for (int i = 0; i < sorts.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < sorts.length; j++) {
                if (sorts[j].compareTo(sorts[min]) < 0) {
                    min = j;
                }
            }
            if (min != i) {
                String tmp = sorts[i];
                sorts[i] = sorts[min];
                sorts[min] = tmp;
            }
        }
    }
}
