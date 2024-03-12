package FileOperations;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JavaFileOperations {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/FileOperations/output.txt"));
        //FileWriter = the 'stream' , BufferedWriter = the actual writer
        writer.write("sofa ti gu sue ma");
        writer.write("\nmueng boak wa gu haam yieb");
        writer.write("\nlaew gu ja plien lord fai yang ngai");
        writer.write("\nEBA!!!!1");
        writer.write("\nma ni gu ja yieb hai mueng doo");
        writer.close();
        readAFile();
    }

    public static void readAFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/FileOperations/readingtest.txt"));
        String line;
        while ((line = reader.readLine()) != null) { // reader will automatically read the next line again and again
            System.out.println(line);
        } 
        reader.close();
    }
}
