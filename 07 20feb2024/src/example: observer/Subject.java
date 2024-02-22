import java.util.ArrayList;
import java.util.List;

public interface Subject {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();

}
class youtubechannel implements Subject{

    //create a list of observers to subscribe
   List<Observer> observers = new ArrayList<Observer>();
   private String message;

   public void registerObserver(Observer observer){
    observers.add(observer);
   }
   public void removeObserver(Observer observer){
    observers.remove(observer);
   }
   public void notifyObserver(){
    for(Observer observer :observers){
        observer.update(message);
    }
}
    public void setmessgae(String message){
        this.message = message;
        notifyObserver();
          
    }

   }


