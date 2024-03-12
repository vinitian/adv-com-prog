# Design Patterns (2) and file operations (read/write)

## #1 : Factory
- the "factory" will create an object to the caller
    - example : `CoffeeFactory.java` | all: `Coffee.java`, `Americano.java`, `Latte.java`, `CoffeeFactory.java`, `CoffeeFactoryTest.java`
- the method `createACoffee()` is the one who will create the objects (Americano, Latte)

- ***Factory Method*** : for more complex processes, you can write factories **within** a factory
    - example: `CoffeeFactoryMethodTest.java` | all: `CoffeeFactoryInterface.java`, `AmericanoFactory.java`, `LatteFactory.java`, `CoffeeFactoryMethodTest.java`

## Java File Operations
- FileWriter = the 'stream' , BufferedWriter = the actual writer
- FileReader = the 'stream' , BufferedReader = the actual reader

## Singleton
- only one instance throughout the whole code (instance = object)
- constructor is private