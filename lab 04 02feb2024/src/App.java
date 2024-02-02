abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract double getArea();
    public abstract void printDetails();
    public abstract void resize(double factor);

}

class Square extends Shape {
    private double length;
    
    public Square(String color, double length) {
        super(color);
        this.length = length;
    }

    public double getArea() {
        return length * length;
    }

    public void printDetails() {
        System.out.println("Shape: Square");
        System.out.println("Color: " + super.getColor());
        System.out.println("Side Length: " + length);
        System.out.println("Area: " + getArea());
    }

    public void resize(double factor) {
        this.length *= factor;
    }
}

class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public void printDetails() {
        System.out.println("Shape: Rectangle");
        System.out.println("Color: " + super.getColor());
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area: " + getArea());
    }  

    public void resize(double factor) {
        this.width *= factor;
        this.height *= factor;
    }
}

class Circle extends Shape{
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    public void printDetails() {
        System.out.println("Shape: Circle");
        System.out.println("Color: " + super.getColor());
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
    }

    public void resize(double factor) {
        this.radius *= factor;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Shape[] shape = new Shape[5];
        shape[0] = new Square("Red", 5.0);
        shape[1] = new Square("Blue", 3.0);
        shape[2] = new Rectangle("Green", 4.0, 6.0);
        shape[3] = new Rectangle("Yellow", 2.0, 8.0);
        shape[4] = new Circle("Orange", 7.0);

        for (Shape s : shape) {
            s.printDetails();
            System.out.println("----------------------");
        }

        // System.out.println("********************");

        // for (Shape s : shape) {
        //     s.resize(2.0);
        //     s.printDetails();
        //     System.out.println("----------------------");
        // }


    }
}
