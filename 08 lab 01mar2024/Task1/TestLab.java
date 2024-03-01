package Task1;
// Class A for reading from the file

import java.io.IOException;

class FileReaderClassA {
    FileReaderSingleton fileReader;
    public FileReaderClassA(FileReaderSingleton fileReader) {
        this.fileReader = fileReader;
    }
    public void readFileLine() throws IOException {
        String line = fileReader.readLineFromFile();
        if (line != null) {
            System.out.println("FileReaderClassA: " + line);
        }
    }
}

// Class B for reading from the file
class FileReaderClassB {
    FileReaderSingleton fileReader;
    public FileReaderClassB(FileReaderSingleton fileReader) {
        this.fileReader = fileReader;
    }
    public void readFileLine() throws IOException {
        String line = fileReader.readLineFromFile();
        if (line != null) {
            System.out.println("FileReaderClassB: " + line);
        }
    }
}

public class TestLab {
    public static void main(String[] args) throws IOException {
        FileReaderSingleton fileReader = FileReaderSingleton.getInstance();
        FileReaderClassA readerA = new FileReaderClassA(fileReader);
        FileReaderClassB readerB = new FileReaderClassB(fileReader);

        // Call the readFileLine() method on both instances
        readerA.readFileLine();
        readerB.readFileLine();
        readerB.readFileLine();
        readerB.readFileLine();
        readerB.readFileLine();
        fileReader.closeFile();
        System.out.println("new round");
        readerA.readFileLine();
        readerB.readFileLine();

    }
}