import java.util.NoSuchElementException;
import java.util.Scanner;

interface ListOfInt {
    public void add(int v);
    public int find(int v);
    public int getMin();
    public int getMax();
}

// creating a new exception class
class ListIsEmptyException extends NoSuchElementException {
    public ListIsEmptyException() {
        super("List is empty");
    }

    public ListIsEmptyException(String message) {
        super(message);
    }
}

class StandardListOfInt implements ListOfInt {
    
    private int[] values = null;
    private int size = 0;

    public StandardListOfInt() {
        values = new int[10];
    }

    private void resize(int moreSpace) { //used only in this class -> private
        int[] newValues = new int[values.length+moreSpace];
        for(int i=0;i<values.length;i++){
            newValues[i] = values[i];
        }
        values = newValues; //make values point to the new array newValues
    }

    public void add(int v){
        if(size >= values.length){
            resize(10);
            
        }
        values[size++] =v;
        return;
    }

    public int find(int v){
        for(int i=0;i<size;i++){
            if(values[i]==v){
                return i;
            }
        }
        return -1;
    }

    public int getMin(){
        if (size <=0) {
            //throw new NoSuchElementException("No elements in the list"); // normally this method must return int, but we can use Exception //once you throw an Exception, it will not do the rest (kinda like return?)
            throw new ListIsEmptyException();
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<size;i++){
            if(values[i] < min){
                min = values[i];
            }
        }
        return min;
    }

    public int getMax() {
        if (size <=0) {
            //throw new NoSuchElementException("No elements in the list");
            // normally this method must return int, but we can use Exception
            //once you throw an Exception, it will not do the rest (kinda like return?)

            throw new ListIsEmptyException("No elements in the list");
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<size;i++){
            if(values[i] > max){
                max = values[i];
            }
        }
        return max;
    }

    public void printList(){
        for(int i=0;i<size;i++){
            System.out.println(values[i]);
        }
    }

    public int[] getArray() {
        return this.values;
    }

    public int getSize() {
        return this.size;
    }
}

class SortedListOfInt extends StandardListOfInt {
    public void add(int v) {
        super.add(v);
        int[] values = this.getArray();
        for (int i = this.getSize()-2; i>=0; i--) { // this.getSize-2 = the one before the last
            if(values[i] > values[i+1]) {
                //swap the values
                int temp = values[i];
                values[i] = values[i+1];
                values[i+1] = temp;
            }

        }
    }

    public int getMin() {
        if(this.getSize() == 0) {
            throw new ListIsEmptyException();
        }
        return this.getArray()[0];
    }

    public int getMax() {
        if(this.getSize() == 0) {
            throw new ListIsEmptyException();
        }
        return this.getArray()[this.getSize()-1];
    }
}
public class App{
    public static void main(String[] args) {

        //ListOfInt myList = new ListOfInt(); //Cannot instantiate the type ListOfInt because it's an interface!
        //ListOfInt myList = new StandardListOfInt(); //use object StandardListOfInt : can use! cannot use new ListOfInt because it's an interface
        //myList.getMin(); //in terminal will show: Exception in thread "main" java.util.NoSuchElementException: No elements in the list
        // instead we can use Try Catch Block so the program can still be continued:
        
        ListOfInt myList = new SortedListOfInt();

        /*
        try {
            myList.getMin();
        }
        catch (Exception e) {
            System.out.println("[In catch block] " + e.getMessage());
        }
        // ⬆️⬇️ compare ListIsEmptyException function with and without the String message parameter
        try {
            myList.getMax();
        }
        catch (Exception e) {
            System.out.println("[In catch block] " + e.getMessage());
        }
        */

        addFromKeyboard(myList);
        addFromKeyboard(myList);
        addFromKeyboard(myList);

        //System.out.println(myList.find(10));
        //myList.printList(); //error because mylist is declared as a ListOfInt, but there's no method printList in the interface class.
        //solution: change myList from ListOfInt to StandardListOfInt : "casting"
        //((StandardListOfInt) myList).printList();

        ((StandardListOfInt) myList).printList();

        System.out.println(myList.getMin());
        System.out.println(myList.getMax());
    }

    public static void addFromKeyboard(ListOfInt l) { //use "static" -- Static members can be accessed without the need to create an instance of the class. This makes them useful for providing utility functions and constants that can be used across the entire program.
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter a number you want to add: "); //use print() not println() จะได้ไม่ตัดบรรทัด
        int x = kb.nextInt();
        l.add(x);
    }
}