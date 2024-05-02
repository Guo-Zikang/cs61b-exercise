public class TestAnimal {
    public static void main(String[] args) {
        Animal a = new Animal("Pluto", 10);
        Cat c = new Cat("Garfield", 6);
        Dog d = new Dog("Fido", 4);
        a.greet(); // ______________________
        c.greet();
        d.greet();
        c.play(); // ______________________
        c.play(":)"); // ______________________
        //d = (Dog) c; error;
        //c = (Cat) a; runtime error;
    }
}