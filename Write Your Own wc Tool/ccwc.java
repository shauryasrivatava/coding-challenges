import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class ccwc {
    public static void main(String[] args) {


            String option = "null";
            String filename = args[0];

        if (args.length == 2) {
             option = args[0];
             filename = args[1];
        }

        try {
            if (option.equals("-c")) {
                // Count bytes
                System.out.println(countBytes(filename)+" "+filename);
            } else if (option.equals("-l")) {
                // Count lines
                System.out.println(countLines(filename)+" "+filename);
            } else if (option.equals("-w")) {
                // Count words
                System.out.println(countWords(filename)+" "+ filename);
            }else if (option.equals("-m")) {
                // Count characters
                System.out.println(countCharacters(filename)+" "+filename);
            }else{
                System.out.println(countBytes(filename)+" "+countLines(filename)+" "+countWords(filename)+" "+filename);
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            System.exit(1);
        }
    }

    private static int countBytes(String filename) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        int byteCount = 0;
        int byteValue;

        while ((byteValue = fileInputStream.read()) != -1) {
            byteCount++;
        }

        fileInputStream.close();
        return byteCount;
    }

    private static int  countLines(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int lineCount = 0;

        while (reader.readLine() != null) {
            lineCount++;
        }

        reader.close();
        return lineCount;
    }

    private static int countWords(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int wordCount = 0;

        String line;
        while ((line = reader.readLine()) != null) {
            // Split each line into words using whitespace as a delimiter
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }

        reader.close();
        return wordCount;
    }
    private static int countCharacters(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        int charCount = 0;

        while (fileReader.read() != -1) {
            charCount++;
        }

        fileReader.close();
        return charCount;
    }
}
