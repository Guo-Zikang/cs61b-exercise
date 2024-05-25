import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class disc07 {
    /** Given an int x and a sorted array A of N distinct integers,
     *  design an algorithm to find if there exists indices i and j
     *  such that A[i] + A[j] == x.
     */
    public static boolean findSum(int[] A, int x) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            if (A[left] + A[right] == x) {
                return true;
            } else if (A[left] + A[right] < x) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(4);
        list.add("a");
        list.add("ab");
        list.add("abc");
        list.add("abcd");
/*
        for (String str : list) {
            if (str.contains("a")) {
                list.remove(str);
            }
        }
        System.out.println(list);
    }
*/

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.equals("a")) {
                // 删除元素
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
