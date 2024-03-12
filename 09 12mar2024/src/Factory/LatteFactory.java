package Factory;
public class LatteFactory implements CoffeeFactoryInterface{
    public Coffee brewCoffee() {
        return new Latte();
    }
}