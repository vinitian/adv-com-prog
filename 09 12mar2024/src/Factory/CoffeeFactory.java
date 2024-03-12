package Factory;
//Design Pattern : Factory

public class CoffeeFactory {
    public Coffee brewACoffee(String coffeeName) {
        if(coffeeName.equals("Americano")) {
            return new Americano();
        }
        else if(coffeeName.equals("Latte")) {
            return new Latte();
        }
        return null;
    }
}