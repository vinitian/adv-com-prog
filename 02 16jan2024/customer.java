public class customer {
    private String Name;
    private int Salary;
    private String Dept;
    private int Raise;

    // ชื่อเหมือน class : function นี้จะเป็นคล้ายๆ __init__ ใน python
    // (สังเกตว่าไม่ต้องบอก type เพราะบังคับว่า type ต้องเป็น customer)
    public customer(String Name, int Salary, String Dept) {
        this.Name = Name;
        this.Salary = Salary;
        this.Dept = Dept;
    }

    public String getName() {
        return Name;
    }
    public int getSalary() {
        return Salary;
    }
    public String getDept() {
        return Dept;
    }

    public void DisplayInfo() {
        System.out.println("Customer Information");

    }
    public int Promotion(int Raise) {
        System.out.println("Customer Promotion");
        this.Salary += Raise;
        return Raise;
        
        
    }

    public static void main(String[] args) {
        customer c1 = new customer("Jenny", 20000, "Mechanical");
        System.out.println(c1.getName());
        System.out.println(c1.getSalary());
        System.out.println(c1.getDept());
        c1.Promotion(5000000);
        System.out.println(c1.getSalary());

    }
}
