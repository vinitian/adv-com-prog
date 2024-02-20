// Decorator Demo

interface Coffee {
    public String getDescription();
    public double getPrice();
}

class Espresso implements Coffee {
    public String getDescription() {
        return "Espresso";
    }
    public double getPrice() {
        return 80;
    }
}

class Latte implements Coffee {
    public String getDescription() {
        return "Latte";
    }
    public double getPrice() {
        return 100;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;
    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }
    public abstract String getDescription();
    public abstract double getPrice();
}

        class Milk extends CoffeeDecorator {
            public Milk(Coffee decoratedCoffee) {
                super(decoratedCoffee);
            }
            public String getDescription() {
                return decoratedCoffee.getDescription() + " with milk";
            }
            public double getPrice() {
                return decoratedCoffee.getPrice() + 10;
            }
        }

        class OatMilk extends CoffeeDecorator {
            public OatMilk(Coffee decoratedCoffee) {
                super(decoratedCoffee);
            }
            public String getDescription() {
                return decoratedCoffee.getDescription() + " with oat milk";
            }
            public double getPrice() {
                return decoratedCoffee.getPrice() + 20;
            }
        }

        class Syrup extends CoffeeDecorator {
            public Syrup(Coffee decoratedCoffee) {
                super(decoratedCoffee);
            }
            public String getDescription() {
                return decoratedCoffee.getDescription() + " with syrup";
            }
            public double getPrice() {
                return decoratedCoffee.getPrice()*3;
            }
        }

//---------------------------------------------

public class DecoraterDemo {
    public static void main(String[] args) {
        Latte l1 = new Latte();
        Espresso e1 = new Espresso();
        System.out.println(l1.getDescription() + " - " + l1.getPrice()+ " " + "Baht");
        System.out.println(e1.getDescription() + " - " + e1.getPrice()+ " " + "Baht");
        Coffee C1 = new OatMilk(l1);
        System.out.println(C1.getDescription() + " - " + C1.getPrice()+ " " + "Baht");
        Coffee C2 = new Syrup(e1);
        System.out.println(C2.getDescription() + " - " + C2.getPrice()+ " " + "Baht");
        Coffee C3 = new Syrup(new Syrup(new OatMilk(e1)));
        System.out.println(C3.getDescription() + " - " + C3.getPrice()+ " " + "Baht");
    }
}
