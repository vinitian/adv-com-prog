package Task2;

import java.util.ArrayList;

public class ControlCenter {
    ArrayList<Door> observerList;
    public ControlCenter() {
        observerList = new ArrayList<Door>();
    }
    public void registerObserver(Door door) {
        observerList.add(door);
    }
    public void openAllDoors() {
        for (Observer observer : observerList) {
            observer.open();
        }
    }
    public void closeAllDoors() {
        for (Door observer : observerList) {
            observer.close();
        }
        
    }

}
