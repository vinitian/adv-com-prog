package Task2;

public class SampleDiscountStrategy implements DiscountStrategy {

    @Override
    public double discount(double discount, double total) {
        return total;
    }
}
