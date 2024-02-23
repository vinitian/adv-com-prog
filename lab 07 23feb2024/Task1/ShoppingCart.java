package Task1;

import java.util.ArrayList;

public class ShoppingCart {
    protected ArrayList<String> items;
    double deliveryFee;
    private boolean[] discountStatus;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.deliveryFee = 0;
        this.discountStatus = new boolean[] {false, false, false};
    }

    public void addItem(String item) {
        items.add(item);
    }

    public double calculateTotal() {
        double sum = 0;
        for (String item : items) {
            String[] s = item.split(":");
            sum += Double.parseDouble(s[1]) * Double.parseDouble(s[2]);
        }
        return sum;
    }
    public void addDeliveryFee(int fee) {
        this.deliveryFee = fee;
    }
    public double getDeliveryFee(){
        return this.deliveryFee;
    }
    public boolean[] getDiscountStatus() {
        return this.discountStatus;
    }
    public void setDiscountStatus(int index, boolean status) {
        this.discountStatus[index] = status;
    }
    public double getNetPrice() {
        return calculateTotal() + this.deliveryFee;
    }
    public void showItems() {
        System.out.println(items);
    }
}