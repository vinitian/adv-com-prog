package Task2;

public class FixedDiscountStrategy implements DiscountStrategy {

    @Override
    public double discount(double discount, double total) {
        return total - discount;
    }
}
