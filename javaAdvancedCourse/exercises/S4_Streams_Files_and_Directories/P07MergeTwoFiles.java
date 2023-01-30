package S4_Streams_Files_and_Directories;

import java.io.*;

public class P07MergeTwoFiles {
    public static void main(String[] args) throws IOException {


        String inputFileOne = "C:\\Users\\Milen\\IdeaProjects\\Java-Advances_EXERCISES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String inputFileTwo = "C:\\Users\\Milen\\IdeaProjects\\Java-Advances_EXERCISES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String outputFile = "C:\\Users\\Milen\\IdeaProjects\\Java-Advances_EXERCISES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Output_07.txt";

        try (InputStream inputStreamOne = new FileInputStream(inputFileOne);
             InputStream inputStreamTwo = new FileInputStream(inputFileTwo);
             OutputStream outputStream = new FileOutputStream(outputFile)) {

            int currentByte = inputStreamOne.read();
            while (currentByte >= 0) {
                outputStream.write(currentByte);
                currentByte = inputStreamOne.read();
            }
            outputStream.write("\n".getBytes());

            currentByte = inputStreamTwo.read();
            while (currentByte >= 0) {
                outputStream.write(currentByte);
                currentByte = inputStreamTwo.read();
            }
        }
    }
}
