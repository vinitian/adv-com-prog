package Singleton;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SingletonLogger {
    private static SingletonLogger instance; //static because getInstance is static //normally, the variables are tied to each object
    private BufferedWriter bw;

    private SingletonLogger() {
        try {
        bw = new BufferedWriter(new FileWriter("src/Singleton/log.txt"));
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeLog() {
        try {
            bw.close();
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void log(String message) {
        try {
            bw.write(message+"\n");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static SingletonLogger getInstance() {
        if(instance == null) { //no instance created yet
            instance = new SingletonLogger();
            return instance;
        }
        return instance;
    }
}
