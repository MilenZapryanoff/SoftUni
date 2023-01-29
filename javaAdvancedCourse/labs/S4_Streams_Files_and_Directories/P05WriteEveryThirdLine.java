package S4_Streams_Files_and_Directories;

import java.io.*;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String basePath = "C:\\Users\\Milen\\IdeaProjects\\Java-Advanced_LABS\\Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\output_p05.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintStream writer = new PrintStream(new FileOutputStream(outputPath))) {

            int lineCount = 1;
            String line = reader.readLine();

            while (line != null) {
                if (lineCount % 3 == 0) {
                    writer.println(line);
                }

                line = reader.readLine();
                lineCount++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}