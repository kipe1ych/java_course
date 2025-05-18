package stage1;

abstract class Animal {
    private int age;

    Animal(int age) {
        if(age < 0) throw new IllegalArgumentException("Отрицательным возраст.");
        this.age = age;
    }

    // добавим абстрактных методов
    public abstract void makesSound();
    public abstract void breathe();

    // добавим методы, которые будут общими у всех животных
    protected void eat() {
        System.out.println("Животное сейчас кушает.");
    }

    public int getAge() {
        return age;
    }
}
