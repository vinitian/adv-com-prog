abstract class Animal {
    private String name;
    public Animal(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract void play();
}

class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
    public void play() {
        System.out.println("I will fly");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    public void play() {
        System.out.println("I'm playing with a ball");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    public String getName() {
        return "I'm a dog. My name is " + super.getName();
    }
    public void play() {
        System.out.println("I'm digging around.");
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        // 1st way:
        // int[] numbers = {1,2,3,4,5,6,7,8,9,10}
        // 2nd way:
        // int[] numbers = new int[10]; // empty array of size 10 (the default value is 0)
        // for(int i=0;i<numbers.length;i++) {
        //     numbers[i] = i+1;
        // }
        // for(int i=0;i<numbers.length;i++) {
        //     // System.out.println(numbers[i]);
        // }
        // for(int number:numbers) {
        //     System.out.println(number);
        // }
        Animal[] animals = new Animal[5]; //array of Animals
        animals[0] = new Dog("DD1");
        animals[1] = new Dog("DD2");
        animals[2] = new Cat("CC1");
        animals[3] = new Cat("CC2");
        animals[4] = new Bird("BB1");
        // for(Animal animal:animals) {
        //     animal.play();
        // }
        for(int i=0;i<animals.length;i++) {
            animals[i].play();
        }
        // Animal a1 = new Animal("AA1");
        // System.out.println(a1.getName());
        // Animal a2 = new Dog("DD1");
        // System.out.println(a2.getName());
        // System.out.println(((Animal) a2).getName());

    }
}
