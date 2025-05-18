package stage1;

abstract class Fish extends Animal implements LivingInWater {

    Fish(int age) {
        super(age);
    }

    @Override
    public void makesSound() {
        System.out.println("Рыба издает странный звук.");
    }

    @Override
    public void breathe() {
        System.out.println("Дышит жабрами");
    }

    @Override
    public void swim() {
        System.out.println("Плавает двигая плавниками");
    }
}
