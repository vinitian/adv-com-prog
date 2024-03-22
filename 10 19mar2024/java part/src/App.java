import java.util.ArrayList;
import java.util.Collections;
//import java.util.*; //import all but load too much 

class Doll implements Comparable<Doll> { //need to implement so that you can actually compare Doll objects
    private String name;
    public Doll(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Doll rhs) { //the objects themselves aren't comparable, so we use their *names* to compare instead
        return this.name.compareTo(rhs.getName());
    }
}

//1️⃣
class ArrayUtils<T extends Comparable<T>> { //generic class...? T is a generic class -- T can be any class
    //ArrayList with the method sort() added
    //T is like a "variable" of the class ArrayUtils
    // T extends Comparable<T> : forces T to be comparable
    private ArrayList<T> a;
    public ArrayUtils() {
        a = new ArrayList<T>(); // empty ArrayList
    }
    public void add(T item) {
        a.add(item);
    }
    public T get(int i) {
        return a.get(i);
    }
    public void sort() {
        Collections.sort(a);
    }
    public int size() {
        return a.size();
    }
    
}

//2️⃣: the subclass way
class MyArrayList<T extends Comparable<T>> extends ArrayList<T> {
    public void sort() {
        Collections.sort(this);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        //ArrayList<Doll> dolls = new ArrayList<Doll>(); // 1️⃣
        ArrayUtils<Doll> dolls = new ArrayUtils<Doll>(); //2️⃣
        dolls.add(new Doll("Nong Nao"));
        dolls.add(new Doll("Nong Foo"));
        dolls.add(new Doll("Nong MaiNao"));

        //Collections.sort(dolls); //1️⃣ //Collections.sort() is static..?

        dolls.sort(); //2️⃣ //if we use ArrayUtils, we don't need to use Collections.sort(dolls);

        for (int i=0;i<dolls.size();i++){
            System.out.println(dolls.get(i).getName()); //ArrayListName.get(index)
        } 

        System.out.println("----------------------------");

        MyArrayList<Doll> c = new MyArrayList<Doll>();
        c.add(new Doll("Nong Nao"));
        c.add(new Doll("Nong Foo"));
        c.add(new Doll("Nong MaiNao"));
        c.sort();
        for(int i=0;i<c.size();i++) {
            System.out.println(c.get(i).getName());

        }
    }
}