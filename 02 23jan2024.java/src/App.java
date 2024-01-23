// ctrl + shift + p > create java project > no build tools > select folder 'java' > name the project
// select and then ctrl + / : comment multiple lines
// windows + arrows : split screen

public class App {
    public static void main(String[] args) throws Exception {
        Account a1 = new Account("23001", "Bob Robertson", 0.0);
        
        /* try running this!
        Account a4 = a1;
        a2 = new SavingsAccount("test", "testt", 0.0, 0.0);
        System.out.println(a1);
        System.out.println(a4);
        */
        // System.out.println(a1);

        // System.out.println(a1.accountHolder); // a1.accountHolder is not visible because the variable is set to private in App.java
       
        /*
        // a1.accountHolder = "Sakurai Haruka"; // ไม่ได้ ต้องใช้ setAccountHolder();
        a1.setAccountHolder("Sakurai Haruka");
        */ 

        /*
        a1.deposit(-10);
        System.out.println(a1);
        a1.deposit(100);
        System.out.println(a1);
        a1.withdraw(999);
        System.out.println(a1);
        a1.withdraw(55);
        System.out.println(a1);
        */

        Account a2 = new SavingsAccount("231001", "Kashiki Yuno", 0.0, 0.3);
        System.out.println(a2);
        Account a3 = new SavingsAccount("231003", "Kajiyama Fuuta", 0.0, 0.4);
        System.out.println(a3);

        /*
        int[] x = {1,2,3,4,5,6};
        // ^ array of integers!!

        //for loop !!!!!!!!!!!!!
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
        */
        
    

        Account[] as = {a1, a2, a3};
        for (int i = 0; i < as.length; i++) {
            System.out.println(as[i]);
        }
    }

}
