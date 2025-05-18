package stage1;

public class Bear extends Mammal implements Wool {

    public Bear(int age) {
        super(age);
        System.out.println("Это медведь. Возраст: " + this.getAge());
    }

    @Override
    public void breathe() {
        System.out.println("Дышит легкими.");
    }

    @Override
    public void makesSound() {
        System.out.println("Медведь рычит.");
    }

    @Override
    public void shedWool() {
        System.out.println("Медведь имеет шерсть и может линять.");
    }
}
