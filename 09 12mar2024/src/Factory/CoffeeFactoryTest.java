package Factory;
//main for Factory

public class CoffeeFactoryTest {
   public static void main(String[] args) {
    CoffeeFactory myCoffeeFactory = new CoffeeFactory();
    Coffee c1 = myCoffeeFactory.brewACoffee("Americano");
    //System.out.println("Ordered Americano");
    Coffee c2 = myCoffeeFactory.brewACoffee("Latte");
    //System.out.println("Ordered Latte");
    Coffee[] coffees = {c1, c2};
    for(Coffee c: coffees) {
        c.brew();
    }
   } 
}
