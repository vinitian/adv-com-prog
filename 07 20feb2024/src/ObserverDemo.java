// Observer demo

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class PM25Sensor { //PM25Sensor is an observable
    ArrayList<Observer> observerList;
    int pm25;
    public PM25Sensor() {
        observerList = new ArrayList<Observer>(); 
        pm25 = -1; 
    }
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(pm25);
        }
    }
    public void setPM25(int pm25) {
        this.pm25 = pm25;
        notifyObservers();
    }
    public void UnregisterObserver(Observer observer) {
        for(int i=0; i<observerList.size(); i++) {
            if(observerList.get(i)==observer){
                observerList.remove(i);
            }
        }
    }
    public void RegisterObserver(Observer observer) {
        observerList.add(observer);
    }
}

interface Observer {
    public void update(int pm25);
}

class WebViewer implements Observer {
    public void update(int pm25) {
        try {
            FileWriter fw = new FileWriter("pm25.html");
            fw.write("<HTML><BODY>"+pm25+"</BODY></HTML>");
            fw.close();
        }   
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

class OnScreenPM25 implements Observer {
    public void update(int pm25) {
        System.out.println("PM2.5: " + pm25);
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        PM25Sensor pmSensor = new PM25Sensor();
        WebViewer webViewer1 = new WebViewer();
        OnScreenPM25 onScreen1 = new OnScreenPM25();
        pmSensor.RegisterObserver(webViewer1);
        pmSensor.RegisterObserver(onScreen1);
        pmSensor.setPM25(135);
        pmSensor.UnregisterObserver(onScreen1);
        pmSensor.setPM25(75);

    }
}