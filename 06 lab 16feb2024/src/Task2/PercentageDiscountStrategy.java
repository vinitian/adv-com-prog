package Task2;

public class PercentageDiscountStrategy implements DiscountStrategy {

    @Override
    public double discount(double discount, double total) {
        return total * ((100 - discount)/100);
    }
}
