public abstract class PizzaDecorator implements Pizza{

    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza){
        this.pizza = pizza;
    }
    public String getdescription(){
        return pizza.getdescription();

    }
    public double getcost(){
        return pizza.getcost();
    }

}
class CheeseDecorator extends PizzaDecorator{

    public CheeseDecorator(Pizza pizza){
        super(pizza);
    }
    public String getdescription(){
        return pizza.getdescription() +" Cheese Toppings";
    }
    public double getcost(){
        return pizza.getcost()+20.0;
    }
}
class ChickenDecorator extends PizzaDecorator{
    public ChickenDecorator(Pizza pizza){
        super(pizza);
    }
    public String getdescription(){
        return pizza.getdescription() +" Chicken Toppings";
    }
    public double getcost(){
        return pizza.getcost() +30.0;
    }
}
