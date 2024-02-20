package Task2;

class ShoppingCart {
    private Item[] items;
    private DiscountStrategy discountStrategy;
    public ShoppingCart() {
        items = new Item[0];
        this.discountStrategy = new SampleDiscountStrategy(); // Default strategy
    }

    public void addItem(Item item) {
        // Extend the array to accommodate the new item
        Item[] newItems = new Item[items.length + 1];
        for(int i=0;i<items.length;i++) {
            newItems[i] = item;
        }
        newItems[items.length] = item;
        items = newItems;
    }

    public void setPercentageDiscountMode() {
        this.discountStrategy = new PercentageDiscountStrategy();
        System.out.println("Discount is set to percentage mode.");
    }

    public void setFixedDiscountMode() {
        this.discountStrategy = new FixedDiscountStrategy();
        System.out.println("Discount is set to fixed mode.");
    }

    public void setSampleDiscountMode() {
        this.discountStrategy = new SampleDiscountStrategy();
        System.out.println("Discount is set to no discount mode.");
        // no discount
    }


    public double calculateTotal(double discount){
        double total = 0;
        for(int i=0;i<items.length;i++) {
            total += items[i].getQuantity() * items[i].getPrice();
        }
  
        return discountStrategy.discount(discount, total);
    }
}