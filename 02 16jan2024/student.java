public class student {
    String Name;
    int Age;
    char Grade;
    //method or function
    public void DisplayInfo(){
        System.out.println("Student Information");
        System.out.println("*******************");
        
        System.out.println("Name: " + Name);
        System.out.println("Age: " + Age);
        System.out.println("Grade: " + Grade);
    }
    
    public static void main(String[] args) {
        student s1 = new student(); // creating an instance of the class (aka object) 
        s1.DisplayInfo();
        s1.Name = "Jenny";
        s1.Age = 25;
        s1.Grade = 'A';
        s1.DisplayInfo();
    }
}
