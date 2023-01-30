package S4_Streams_Files_and_Directories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class P06WordCount {
    public static void main(String[] args) throws IOException {

        //прочитане на файла с думите, които ще търсим
        String pathWords = "C:\\Users\\Milen\\IdeaProjects\\Java-Advances_EXERCISES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        //създаване на лист с редовете от файла
        List<String> allLinesWithWords = Files.readAllLines(Path.of(pathWords));
        //създаване на map
        Map<String, Integer> countWords = new LinkedHashMap<>();

        //обхождане на листа и попълване на Map-а
        for (int i = 0; i < allLinesWithWords.size(); i++) {
            String[] currentLine = allLinesWithWords.get(i).split("\\s+");

            for (int j = 0; j < currentLine.length; j++) {
                countWords.put(currentLine[j], 0);
            }
        }

        //прочитане на файлс с текста
        String pathToTextFile = "C:\\Users\\Milen\\IdeaProjects\\Java-Advances_EXERCISES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        //създаване на лист с редовете от файла с текст
        List<String> allLinesWithText = Files.readAllLines(Path.of(pathToTextFile));
        //обхождане на листа и прочитане на редовете
        for (int i = 0; i < allLinesWithText.size(); i++) {
            String line = allLinesWithText.get(i);
            //създаване на масив с димите от редовете
            String[] currentLine = line.split("\\s+");
            //обхождане на масива и match-ване с map-a
            for (int j = 0; j < currentLine.length; j++) {
                String currentWord = currentLine[j];
                //ако думата се съдържа в map-а, упдейтваме value-то в мап-а
                if (countWords.containsKey(currentWord)) {
                    int counter = countWords.get(currentWord);
                    countWords.put(currentWord, counter + 1);
                }
            }

        }
        //създаване на printWriter за да формираме нов файл
        PrintWriter printWriter = new PrintWriter("C:\\Users\\Milen\\IdeaProjects\\Java-Advances_EXERCISES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\result.txt");

        //сортиране на масива по value, обхождане и писане във файл.
        countWords.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> printWriter.println(entry.getKey() + " - " + entry.getValue()));
        printWriter.close();
    }
}

