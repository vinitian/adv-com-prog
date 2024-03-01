package Task1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderSingleton {
    private static FileReaderSingleton instance = null;
    private BufferedReader reader;

    private FileReaderSingleton() throws FileNotFoundException {
        openFile();
    }

    private void openFile() throws FileNotFoundException{
        try {
            reader = new BufferedReader(new FileReader("src/data.txt"));
        } catch (Exception e) {
            throw new FileNotFoundException("[In catch block] " + e.getMessage());
        }
    }

    public void closeFile() throws IOException {
        try {
            reader.close();
        } catch (IOException  e) {
			System.out.println("[In catch block] " + e.getMessage()); 
		} 
    }

    public static FileReaderSingleton getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new FileReaderSingleton();
        }
        return instance;
    }

    public String readLineFromFile() throws IOException {
        try {
            
			String line = reader.readLine();
			return line;

		} catch (IOException  e) {
            openFile();
            String line = reader.readLine();
			return line;          
		} 

    }


}
