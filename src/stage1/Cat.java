package stage1;

public class Cat extends Mammal implements Wool {

    public Cat(int age) {
        super(age);
        System.out.println("Это кот. Возраст: " + this.getAge());
        this.eat();
    }

    @Override
    public void breathe() {
        System.out.println("Дышит легкими.");
    }

    @Override
    public void makesSound() {
        System.out.println("Кот мяукает.");
    }

    @Override
    public void shedWool() {
        System.out.println("Кот имеет шерсть и может линять.");
    }
}
