import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TestFile {
    

    public HashMap<String, int[]> read_scores(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        boolean firstLine = true;
        HashMap<String, int[]> output = new HashMap<>();
        String line;
        
        while ((line = reader.readLine()) != null) { // reader will automatically read the next line again and again
            if (firstLine) {
                firstLine = false;
                continue;
            }
            String[] a = line.split(",");
            String ID = a[0];
            int[] score = new int[a.length - 1];
            for (int i = 0; i < score.length; i++) {
                score[i] = Integer.parseInt(a[i+1]);
            }
            
            output.put(ID, score);
        } 
        reader.close();
        return output;
    }

    public int getTotalScore(HashMap<String, int[]> data, String ID) {
        if (data.containsKey(ID)) {
            int total = 0;
            for (int i : data.get(ID)) {
                total += i;
            }
            return total;
        }
        return -1;
    }

    public HashSet<String> getEditedStudentID(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        HashSet<String> IDList = new HashSet<>();
        boolean firstLine = true;
        String line;
        
        while ((line = reader.readLine()) != null) { // reader will automatically read the next line again and again
            if (firstLine) {
                firstLine = false;
                continue;
            }
            String[] a = line.split(",");
            String ID = a[0];
            IDList.add(ID);
        } 
        reader.close();
        return IDList;
    }

    public void createNewEditedScore(String studentScores, String editedScores, String newScores) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(newScores));
        HashMap<String, int[]> oldScores = read_scores(studentScores);
        BufferedReader reader = new BufferedReader(new FileReader(editedScores));
        String line;
        boolean firstLine = true;

        while ((line = reader.readLine()) != null) { // reader will automatically read the next line again and again
            if (firstLine) {
                firstLine = false;
                continue;
            }
            String[] a = line.split(",");
            String ID = a[0];
            if (oldScores.containsKey(ID)) {
                oldScores.get(ID)[Integer.parseInt(a[1])-1] = Integer.parseInt(a[2]);
            }
        }
        for(Map.Entry<String, int[]> e : oldScores.entrySet()) { //Entry รับ e เป็น tuple jsut as in python
            writer.write(e.getKey() + "," + e.getValue()[0] + "," + e.getValue()[1] + "," + e.getValue()[2] + "," + e.getValue()[3] + "," + e.getValue()[4] + "\n");
        }
        reader.close();
        writer.close();

    }
}