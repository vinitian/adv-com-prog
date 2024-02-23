package Task2;

public class Door implements Observer {
    private String doorName;
    private boolean isOpen = false;
    public Door(String doorName) {
        this.doorName = doorName;
    }
    public void open() {
        this.isOpen = true;
        System.out.println("Door " + this.doorName + " opened");
    }
    public void close() {
        this.isOpen = false;
        System.out.println("Door " + this.doorName + " closed");
    }
    public void getDoorStatus() {
        if (this.isOpen == true) {
            System.out.println("Door " + this.doorName + " is currently opened");
        }
        else {
            System.out.println("Door " + this.doorName + " is currently closed");
        }
    }
}
