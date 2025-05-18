package stage1;

abstract class Mammal extends Animal implements Spine {

    Mammal(int age) {
        super(age);
    }

    @Override
    public void hasSpine() {
        System.out.println("Есть позвоночник.");
    }
}
