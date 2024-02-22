public class App {
    public static void main(String[] args) throws Exception {
        Pizza pizza1 = new PlainPizza();
        pizza1 = new CheeseDecorator(pizza1);
        System.out.println("Bill for the Pizza with CheeseDecorator");
        System.out.println("Description" +pizza1.getdescription());
        System.out.println("Cost" +pizza1.getcost());

        Pizza pizza2 = new PlainPizza();
        pizza2 = new ChickenDecorator(pizza2);
        System.out.println("Bill for the Pizza with ChickenDecorator");
        System.out.println("Description" +pizza2.getdescription());
        System.out.println("Cost" +pizza2.getcost());

        Pizza pizza3 = new PlainPizza();
        pizza3 =new ChickenDecorator(new CheeseDecorator(pizza3));
        System.out.println("Bill for the Pizza with CheeseDecorator & ChickenDecorator");
        System.out.println("Description" +pizza3.getdescription());
        System.out.println("Cost" +pizza3.getcost());




        
    }
}
