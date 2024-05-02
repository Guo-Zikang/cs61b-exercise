import java.util.Comparator;

public class Maximizer {
    public static Comparable max(Comparable[] items) {
        if (items.length == 0) return null;
        int m = 0;
        for (int i = 1; i < items.length; i++) {
            if (items[i].compareTo(items[m]) > 0) {
                m = i;
            }
        }
        return items[m];
    }

    public static void main(String[] args) {
        Dog[] dogs = {new Dog("Elyse", 3), new Dog("B", 10), new Dog("C", 8)};
        Dog maxDog = (Dog) Maximizer.max(dogs);
        System.out.println(maxDog);
        maxDog.bark();

        Comparator<Dog> nc = Dog.getNameComparator();
        if (nc.compare(dogs[0], dogs[2]) > 0) {
            dogs[0].bark();
        } else {
            dogs[2].bark();
        }
    }
}
