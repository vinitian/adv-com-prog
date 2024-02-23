package Task2updated;

import java.util.ArrayList;

public class ControlCenter {
    ArrayList<Observer> observerList;
    public ControlCenter() {
        observerList = new ArrayList<Observer>();
    }
    public void registerObserver(Observer observer) {
        observerList.add(observer);
        System.out.println("Succesfully registered " + observer.getName());
    }
    public void openAllObservers() {
        for (Observer observer : observerList) {
            observer.open();
        }
    }
    public void closeAllObservers() {
        for (Observer observer : observerList) {
            observer.close();
        }
        
    }

}
