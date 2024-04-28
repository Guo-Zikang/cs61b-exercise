public class disc02 {
    public static int mystery(int[] inputArray, int k) {
        int x = inputArray[k];
        int answer = k;
        int index = k + 1;
        while (index < inputArray.length) {
            if (inputArray[index] < x) {
                x = inputArray[index];
                answer = index;
            }
            index = index + 1;
        }
        return answer;
    }

    /*迭代法 */
    public static int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int before1 = 0, before2 = 1, now = 0;
        while (n > 1) {
            now = before1 + before2;
            before1 = before2;
            before2 = now;
            n--;
        }
        return now;
    }

    /*尾递归法 */
    public static int fibHelper(int n, int k, int f0, int f1) {
        if (n == k)
            return f0;
        return fibHelper(n, k + 1, f1, f0 + f1);
    }

    public static int fib2(int n) {
        return fibHelper(n, 0, 0, 1);
    }

    /*尾递归法的另外一种写法 */
    public static int fib3(int n, int first, int second) {
        if (n == 0)
            return 0;
        if (n == 1)
            return first;
        return fib3(n - 1, second, first + second);
    }

    public static void main(String[] args) {
        // int[] array = {3, 0, 4, 6, 3, 1};
        // System.out.println(mystery(array, 2));
        System.out.println(fib(8));
        System.out.println(fib2(8));
        System.out.println(fib3(8, 1, 1));
    }
}
