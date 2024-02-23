[link to the playlist](https://www.youtube.com/playlist?list=PLwnUv3sNB6_UsjZFlSJdEdRA_Z6wYKAz5)

# polymorphism

note: Dog is a subclass of Animal

`Animal a2 = new Dog("Wolfy");`
- reference variable `Animal` says a2 can call 2 methods: constructor, getName()
- object `Dog` actually has 3 methods: constructor, getName(), bark()
- can only use getName() and uses Dog's method (Dog's getName() overrides Animal's)

`Dog a3 = new Animal("Charchar");`
- reference variable `Dog` says a3 can call 3 methods: constructor, getName(), bark()
- object `Animal` actually has 2 methods: constructor, getName()
- will become error because Animal may not have method Dog has e.g. bark()

# array

1st way: `int[] numbers = {1,2,3,4,5,6,7,8,9,10}`
2nd way: `int[] numbers = new int[9];` -> creates an empty array of size 9 (the default value is 0)

for loop example:
```java
int[] numbers = new int[9];
for(int i=0;i<numbers.length;i++) {
    numbers[i] = i+1;
    }
```

```java
for(int number:numbers) { //similar to `for char in list` / `for number in numbers` in python
System.out.println(number);
}
```

# array of objects

```java
Animal[] animals = new Animal[5]; //array of Animals
        animals[0] = new Dog("DD1");
        animals[1] = new Dog("DD2");
        animals[2] = new Cat("CC1");
        animals[3] = new Cat("CC2");
        animals[4] = new Bird("BB1");
        for(Animal animal:animals) {
            animal.play();
        }
```

# abstract class
- uses to declare a method you don't want to implement yet
- forces you to implement the method in every subclass (so you don't forget to)
example:
```java
abstract class Animal { // must have abstract here
    private String name;
    public Animal(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract void play(); // and also abstract here
}
```
then, a subclass:
```java
class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
    public void play() { // **must** implement method play()
        System.out.println("I will fly");
    }
}
```
