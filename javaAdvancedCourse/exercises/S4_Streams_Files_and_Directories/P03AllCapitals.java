package S4_Streams_Files_and_Directories;

import java.io.*;

public class P03AllCapitals {
    public static void main(String[] args) {

        String pathToFile = "C:\\Users\\Milen\\IdeaProjects\\Java-Advances_EXERCISES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputFile = "C:\\Users\\Milen\\IdeaProjects\\Java-Advances_EXERCISES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output_03.txt";

        try (InputStream inputStream = new FileInputStream(pathToFile);
             OutputStream outputStream = new FileOutputStream(outputFile)) {

            int currentByte = inputStream.read();

            while (currentByte >= 0) {
                outputStream.write(Character.toUpperCase(currentByte));

                currentByte = inputStream.read();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
