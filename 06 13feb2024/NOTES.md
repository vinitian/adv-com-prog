# Design Patterns

[Colab link](https://colab.research.google.com/drive/19egTeGBtDtMiuoQV0y9bsfwxaGUM0xGE?usp=sharing)

<mark>test highlist in markdown</mark>

## OCP (Open and Closed Principle)
- = Open for inheritance, closed for modification

## Designing
- should we use a normal class, an abstract class, or an interface?
    - doesn't know how to implement a function yet -> interface (e.g. we don't know how a general animal will make a sound so we just put the Animal class)
- take a look at this code:
``` java
interface  Animal {
    public void makeSound();
}

class Poodle implements Animal {

    public String name;
    public Poodle(String name) {
        this.name = name;
    }
    public void makeSound() {
        System.out.println("ワンワン！");
    }
}

class Husky implements Animal {
    private String name;
    public Husky(String name) {
        this.name = name;
    }
    public void makeSound() {
        System.out.println("ワンワン！");
    }
}

class Persian implements Animal {
    private String name;  
    public Persian(String name) {
        this.name = name;
    }
    public void makeSound() {
        System.out.println("にゃんにゃん :3");
    }
}
```
1. both the Poodle and Husky class say　ワンワン！
2. what if we need to translate the sounds into other languages? Then it'd be a pain to edit all those classes... imagine if we have 100 classes....
- --> create `interface MakeSoundStrategy`! that way, there would be less redundant code (e.g. Poodle and Husky) and it'd be easier to edit -- **"Dynamic Strategy"**

- **Static Strategy**: can't change SoundStrategy, only at when creating the object
```java

class Animal {
    private MakeSoundStrategy soundStrategy;
    public Animal(MakeSoundStrategy soundStrategy) {
        this.soundStrategy = soundStrategy;
    }
    public void makeSound() {
        soundStrategy.makeSound();
    }
}

```

so it can only do this:
```java
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
```


- **Dynamic Strategy** : can change soundStrategy later
```java
class Animal {
    private MakeSoundStrategy soundStrategy;
    public void makeSound() {
        soundStrategy.makeSound();
    }
    public void setSoundStrategy(MakeSoundStrategy soundStrategy) {
        this.soundStrategy = soundStrategy;
    }

}
```
so it can do this:
```java
public class App {
    public static void main(String[] args) throws Exception {
        Husky d1 = new Husky("Husky D1");
        d1.setSoundStrategy(new BarkStrategy());
        d1.makeSound(); //wanwan
        d1.setSoundStrategy(new MeowStrategy());
        d1.makeSound(); //meowww
    }
}
```




# Others
- `@Override` : means that the function below will override the parent class's. not required but it is good practice/convention to write this esp if you work in a team


# questions
1. in PythonList.java, why is it not named findMinMaxStrategy? how do we decide which class is supposed to be the name of the file? : the `public` one.
2. we can have multiple `public static void main(String[] args)` ??? : yes.