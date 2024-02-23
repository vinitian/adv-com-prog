package Task1;

public abstract class ShoppingCartDecorator extends ShoppingCart {
    protected ShoppingCart cart;
    
    public ShoppingCartDecorator(ShoppingCart cart) {
        this.cart = cart;
    }
    public double calculateTotal() {
        return cart.calculateTotal();
    }
    public void showItems() {
        System.out.println(cart.items);
    }
    public double getDeliveryFee() {
        return cart.getDeliveryFee();
    }
    public abstract double getNetPrice();
}

class DiscountByPercentDecorator extends ShoppingCartDecorator {
    double discount;
    public DiscountByPercentDecorator(ShoppingCart cart, double d) {
        super(cart);
        this.discount = d;
    }
    public double getNetPrice() {
        if (cart.getDiscountStatus()[0] == false) {
            cart.setDiscountStatus(0, true);
            return cart.calculateTotal() * (1 - discount/100) + cart.getDeliveryFee();
        }
        else {
            return cart.getNetPrice();
        }
        
    }

}

class DiscountByAmountDecorator extends ShoppingCartDecorator {
    double discount;
    public DiscountByAmountDecorator(ShoppingCart cart, double discount) {
        super(cart);
        this.discount = discount;
    }
    public double getNetPrice() {
        if (cart.getDiscountStatus()[1] == false) {
            cart.setDiscountStatus(1, true);
            return cart.getNetPrice() - this.discount;
        }
        else {
            return cart.getNetPrice();
        }
    }

}

class FreeDeliveryDecorator extends ShoppingCartDecorator {
    public FreeDeliveryDecorator(ShoppingCart cart) {
        super(cart);
    }
    public double getNetPrice() {
        if (cart.getDiscountStatus()[2] == false) {
            cart.setDiscountStatus(1, true);
            return cart.getNetPrice() - cart.getDeliveryFee();
        }
        else {
            return cart.getNetPrice();
        }
    }

}

