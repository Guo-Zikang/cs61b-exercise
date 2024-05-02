import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    private int size;
    private String name;
    public Dog( String n, int s){
        size = s;
        name = n;
    }
    public void bark() {
        System.out.println(name + " says: bark");
    }
    @Override
    public int compareTo(Dog uddaDog) {
        return size - uddaDog.size;
    }
    private static class nameComparator implements Comparator<Dog> {
        @Override
        public int compare(Dog a, Dog b) {
            return a.name.compareTo(b.name);
        }
    }
    public static Comparator<Dog> getNameComparator() {
        return new nameComparator();
    }
}
