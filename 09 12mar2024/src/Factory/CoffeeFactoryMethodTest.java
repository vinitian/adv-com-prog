package Factory;
//main for Factory Method

public class CoffeeFactoryMethodTest {
    public static void main(String[] args) {
        AmericanoFactory americanoFactory = new AmericanoFactory();
        LatteFactory latteFactory = new LatteFactory();
        Coffee c1 = americanoFactory.brewCoffee();
        Coffee c2 = latteFactory.brewCoffee();
        Coffee c3 = latteFactory.brewCoffee();
        Coffee[] coffees = {c1, c2, c3};
        for(Coffee c: coffees){
            c.brew();
        }

    }
}
