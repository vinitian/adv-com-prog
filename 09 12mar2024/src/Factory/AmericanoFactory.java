package Factory;
public class AmericanoFactory implements CoffeeFactoryInterface{
    public Coffee brewCoffee() {
        return new Americano();
    }
}
