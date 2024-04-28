public class hw0 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
        int[] numbers = new int[] { 4, 7, 10 };
        System.out.println(numbers[1]);
    }
}