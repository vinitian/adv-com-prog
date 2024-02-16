package Task2;

public class App {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("Widget", 3, 10.99);
        Item item2 = new Item("Gadget", 2, 19.99);

        cart.addItem(item1);
        cart.addItem(item2);

        // Your cart should set different discount strategies and display the total cost after discount.
        cart.setPercentageDiscountMode();
        System.out.println(cart.calculateTotal(25.57));
        cart.setFixedDiscountMode();
        System.out.println(cart.calculateTotal(25.57));
        cart.setSampleDiscountMode();
        System.out.println(cart.calculateTotal(25.57));
    }
}