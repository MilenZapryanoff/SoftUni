package S4_Streams_Files_and_Directories;

import java.io.*;

public class P03CopyBytes {
    public static void main(String[] args) {

        String basePath = "C:\\Users\\Milen\\IdeaProjects\\Java-Advanced_LABS\\Files-and-Streams-Lab-Resources";
        String inputFile = basePath + "\\input.txt";
        String outputFile = basePath + "\\output_p03.txt";

        try (InputStream inputStream = new FileInputStream(inputFile);
             OutputStream outputStream = new FileOutputStream(outputFile)) {

            int currentByte = inputStream.read();

            while (currentByte >= 0) {

                if (currentByte == 10 || currentByte == 32)
                    outputStream.write(currentByte);
                else {
                    String number = String.valueOf(currentByte);
                    for (int i = 0; i < number.length(); i++) {
                        outputStream.write(number.charAt(i));
                    }
                }
                currentByte = inputStream.read();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
