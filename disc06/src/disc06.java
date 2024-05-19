import static java.util.Arrays.sort;

/** returns true if every int has a duplicate in the array,
 *  and false if there is any unique int in the array. */
public class disc06 {
    public static boolean noUniques(int[] array) {
        sort(array);
        int N = array.length;
        int curr = array[0];
        boolean unique = true;
        for (int i = 1; i < N; i++) {
            if (array[i] == curr) {
                unique = false;
            } else if (unique) {
                return false;
            } else {
                unique = true;
                curr = array[i];
            }
        }
        return !unique;
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        array[0] = 1;
        array[1] = 3;
        array[2] = 1;
        array[3] = 3;
        array[4] = 4;
        array[5] = 1;
        array[6] = 4;
        array[7] = 5;
        System.out.println(noUniques(array));
    }
}
