package S4_Streams_Files_and_Directories;

import java.io.File;

public class P07ListFiles {
    public static void main(String[] args) {

        String folderPath = "C:\\Users\\Milen\\IdeaProjects\\Java-Advanced_LABS\\Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(folderPath);

        File[] nestedFiles = file.listFiles();
        for (File currentFile : nestedFiles) {
            if (currentFile.isFile()) {
                System.out.printf("%s: [%d]%n", currentFile.getName(), currentFile.length());
            }
        }

    }
}
