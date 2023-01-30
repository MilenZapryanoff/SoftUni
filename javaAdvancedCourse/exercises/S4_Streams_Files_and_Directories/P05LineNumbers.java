package S4_Streams_Files_and_Directories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException {

        String pathToFile = "C:\\Users\\Milen\\IdeaProjects\\Java-Advances_EXERCISES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        List<String> allLines = Files.readAllLines(Path.of(pathToFile));

        int line = 1;
        for (int i = 0; i < allLines.size(); i++, line++) {
            System.out.printf("%d. %s%n", line, allLines.get(i));

        }
    }
}
