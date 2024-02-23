package Task2updated;

public class Window implements Observer {
    private String windowName;
    private boolean isOpen = false;
    public Window(String windowName) {
        this.windowName = windowName;
    }
    public String getName() {
        return this.windowName;
    }
    public void open() {
        this.isOpen = true;
        System.out.println("Window " + this.windowName + " opened");
    }
    public void close() {
        this.isOpen = false;
        System.out.println("Window " + this.windowName + " closed");
    }
    public void getWindowStatus() {
        if (this.isOpen == true) {
            System.out.println("Window " + this.windowName + " is currently opened");
        }
        else {
            System.out.println("Window " + this.windowName + " is currently closed");
        }
    }
}
