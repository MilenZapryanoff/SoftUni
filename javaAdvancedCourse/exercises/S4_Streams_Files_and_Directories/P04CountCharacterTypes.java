package S4_Streams_Files_and_Directories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class P04CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        String pathToFile = "C:\\Users\\Milen\\IdeaProjects\\Java-Advances_EXERCISES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        int vowelsCounter = 0;
        int symbolsCounter = 0;
        int punctuationCounter = 0;

        try (InputStream inputStream = new FileInputStream(pathToFile)) {
            int currentByte = inputStream.read();


            while (currentByte >= 0) {

                if (currentByte == 'a' || currentByte == 'e' || currentByte == 'i' || currentByte == 'o' || currentByte == 'u') {
                    vowelsCounter++;
                } else if (currentByte == ',' || currentByte == '.' || currentByte == '?' || currentByte == '!') {
                    punctuationCounter++;
                } else if (!(currentByte == '\r' || currentByte == '\n' || currentByte == ' ')) {
                    symbolsCounter++;
                }


                currentByte = inputStream.read();
            }
        }
        System.out.printf("Vowels: %d%n", vowelsCounter);
        System.out.printf("Other symbols: %d%n", symbolsCounter);
        System.out.printf("Punctuation: %d%n", punctuationCounter);
    }
}