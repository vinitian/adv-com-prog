import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class DataCollectionsDemo {
    public static void main(String[] args) {
        //Map = dict in python
        Map<String, Double> data = new HashMap<>(); //Double is the class of double. likewise, Integer is the class of integer
        data.put("ID0001", 20.1);
        data.put("ID0002", 32.4);
        data.put("ID0003", 18.0);

        if(data.containsKey("ID0003")) {
            System.out.println(data.get("ID0003"));
        }
        if(data.containsKey("ID0004")) {
            System.out.println(data.get("ID0004"));
        }

        System.out.println("------------");

        for(Map.Entry<String, Double> e : data.entrySet()) { //Entry รับ e เป็น tuple jsut as in python
            System.out.println(e.getKey() + " : " + e.getValue());
        }

        System.out.println("------------");

        data.remove("ID0003");
        if(data.containsKey("ID0003")) {
            System.out.println(data.get("ID0003"));
        }

        //------------------------------------------------------
        //Set
        Set<String> s = new HashSet<>();
        s.add("apple");
        s.add("banana");
        s.add("cherry");
        if (s.contains("apple")) {
            System.out.println("Yes, apple is available.");
        }
        for(String s1 : s) {
            System.out.println(s1); // set : no order (notice how it's not even apple banana cherry); order can't be expected
        }

        System.out.println("------------");

        s.remove("apple");
        for(String s1 : s) {
            System.out.println(s1);
        }

    }
}
