[link to the playlist](https://www.youtube.com/playlist?list=PLwnUv3sNB6_UsjZFlSJdEdRA_Z6wYKAz5)


# interface


# static
[static keyword in Java (GFG)](https://www.geeksforgeeks.org/static-keyword-java/)


# Exception
- `throw new exception`
- if thrown, the program will be stopped (kinda like `return`)
- the ones java already provides
- creating a new exception class
``` java
class ListIsEmptyException extends NoSuchElementException {
    public ListIsEmptyException() {
        super("List is empty");
    }

    public ListIsEmptyException(String message) {
        super(message);
    }
}
```

# try catch block
- if it catches an exception, it'll throw but still continue the program

# Scanner (like input in python)
``` java
import java.util.Scanner;

    public static void addFromKeyboard(ListOfInt l) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter a number you want to add: ");
        int x = kb.nextInt();
        l.add(x);
    }
```

# other commands
- `System.out.print()` : no new line after
- `System.out.println()` : has new line after
- `Integer.MIN_VALUE` : the minimum possible value for any integer variable in Java = -2^31 = -2147483648
- `Integer.MAX_VALUE` : the maximum possible value for any integer variable in Java = 2^31 - 1 = 2147483647 [source (GFG)](https://www.geeksforgeeks.org/integer-max_value-and-integer-min_value-in-java-with-examples/)
- `arrayName.length` : returns length of the array
