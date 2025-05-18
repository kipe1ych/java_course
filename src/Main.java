import stage1.Bear;
import stage1.Cat;
import stage1.Whale;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    Main() {
        Cat cat = new Cat(2);
        Bear bear = new Bear(12);
        Whale whale = new Whale(12);

        whale.swim();
    }

}