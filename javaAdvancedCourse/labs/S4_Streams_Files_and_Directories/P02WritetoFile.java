package S4_Streams_Files_and_Directories;

import java.io.*;

public class P02WritetoFile {
    public static void main(String[] args) throws IOException {

        String basePath = "C:\\Users\\Milen\\IdeaProjects\\Java-Advanced_LABS\\Files-and-Streams-Lab-Resources";
        String inputFile = basePath + "\\input.txt";
        String outputFile = basePath + "\\output.txt";

        OutputStream outputStream = new FileOutputStream(outputFile);

        try (InputStream inputStream = new FileInputStream(inputFile)) {

            int currentByte = inputStream.read();
            while (currentByte >= 0) {

                String currentChar = String.valueOf((char) currentByte);

                if (!(currentChar.equals(",") || currentChar.equals(".") ||
                        currentChar.equals("!") || currentChar.equals("?"))) {
                    
                    outputStream.write(currentByte);
                }
                currentByte = inputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        outputStream.close();
    }
}
