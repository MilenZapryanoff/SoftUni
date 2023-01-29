package S4_Streams_Files_and_Directories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class P02SumBytes {
    public static void main(String[] args) throws IOException {

        String pathToFile = "C:\\Users\\Milen\\IdeaProjects\\Java-Advances_EXERCISES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        byte[] allBytes = Files.readAllBytes(Path.of(pathToFile));

        long sum = 0;


        for (byte currentbyte : allBytes) {
            if (currentbyte != '\n' && currentbyte != '\r') {
                sum += currentbyte;
            }
        }

//        try (InputStream inputStream = new FileInputStream(pathToFile)) {
//
//            int currentByte = inputStream.read();
//
//            while (currentByte >= 0) {
//                if (currentByte != '\n' && currentByte != '\r') {
//                    sum += currentByte;
//                }
//                currentByte = inputStream.read();
//            }
//        }
        System.out.println(sum);
    }
}
