package S4_Streams_Files_and_Directories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class P06SortLines {
    public static void main(String[] args) throws IOException {

        String basePath = "C:\\Users\\Milen\\IdeaProjects\\Java-Advanced_LABS\\Files-and-Streams-Lab-Resources";
        String inputFile = basePath + "\\input.txt";
        String outputFile = basePath + "\\output_p06.txt";

        Path path = Paths.get(inputFile);

        List<String> sortedLines = Files.readAllLines(path)
                .stream().sorted().collect(Collectors.toList());

        Path outputPath = Paths.get(outputFile);
        Files.write(outputPath, sortedLines);
    }
}
