// holy shit pls check NOTES.md for this there are a lot of changes

// interface  Animal {
//     public void makeSound(); // we don't know what sound a 'general animal' would make, so we make it abstract / an interface
// }

class Animal {
    private MakeSoundStrategy soundStrategy;
    public Animal(MakeSoundStrategy soundStrategy) {
        this.soundStrategy = soundStrategy;
    }
    public void makeSound() {
        soundStrategy.makeSound();
    }

}

//--------------------------------------------------------

interface MakeSoundStrategy {
    public void makeSound();
}

class BarkStrategy implements MakeSoundStrategy {
    public void makeSound() {
        System.out.println("wanwan");
    }
}

class MeowStrategy implements MakeSoundStrategy {
    public void makeSound() {
        System.out.println("meowww");
    }
}


//---------------------------------------------------------


class Poodle extends Animal {

    public String name;
    public Poodle(String name, MakeSoundStrategy soundStrategy) {
        super(soundStrategy);
        this.name = name;
    }
}

class Husky extends Animal {
    private String name;
    public Husky(String name, MakeSoundStrategy soundStrategy) {
        super(soundStrategy);
        this.name = name;
    }
}

class Persian extends Animal {
    private String name;  
    public Persian(String name, MakeSoundStrategy soundStrategy) {
        super(soundStrategy);
        this.name = name;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        // for Dynamic Strategy
        // Husky d1 = new Husky("Husky D1");
        // d1.setSoundStrategy(new BarkStrategy());
        // d1.makeSound();
        // d1.setSoundStrategy(new MeowStrategy());
        // d1.makeSound();

        // Poodle d2 = new Poodle("Poodle D2");
        // d2.setSoundStrategy(new BarkStrategy());
        // d2.makeSound();

        //for Static Strategy
        Husky d1 = new Husky("Husky D1", new BarkStrategy());
        d1.makeSound();
        Poodle d2 = new Poodle("Poodle D2", new BarkStrategy());
        d2.makeSound();
        Persian c1 = new Persian("Persian C1", new MeowStrategy());
        c1.makeSound();
    }
}
