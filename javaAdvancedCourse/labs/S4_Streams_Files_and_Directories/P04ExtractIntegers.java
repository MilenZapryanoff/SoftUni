package S4_Streams_Files_and_Directories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String basePath = "C:\\Users\\Milen\\IdeaProjects\\Java-Advanced_LABS\\Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\output_p04.txt";

        Scanner reader = new Scanner(new FileInputStream(inputPath));
        PrintStream writer = new PrintStream(new FileOutputStream(outputPath));

        while (reader.hasNext()) {
            if (reader.hasNextInt()) {
                writer.println(reader.nextInt());
            }

            reader.next();
        }
    }
}
