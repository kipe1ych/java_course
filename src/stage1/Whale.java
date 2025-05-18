package stage1;

public class Whale extends Mammal implements LivingInWater {

    public Whale(int age) {
        super(age);
        System.out.println("Это кит. Возраст: " + this.getAge());
    }

    @Override
    public void breathe() {
        System.out.println("Делает вдох через дыхало, может долго не дышать после этого.");
    }

    @Override
    public void makesSound() {
        System.out.println("Кит издает низкочастотные звуки.");
    }

    @Override
    public void swim() {
        System.out.println("Кит умеет плавать.");
    }
}
