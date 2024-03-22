import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class TestFile {
    
    BufferedReader reader;
    public TestFile() {
        
    }
    public HashMap<String, int[]> read_scores() throws FileNotFoundException {
        Map<String, int[]> output = new HashMap<>();
        String line;
        reader = new BufferedReader(new FileReader("student_scores.csv"));
        while ((line = reader.readLine()) != null) { // reader will automatically read the next line again and again
            
        } 
        reader.close();
        return
    }

}
