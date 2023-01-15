package S7_Associative_Arrays_Maps_Lambda_and_Stream_API;

import java.util.*;

public class P02WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, List<String>> wordsMap = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            List<String> synonyms = new ArrayList<>();
            String key = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (!wordsMap.containsKey(key)) {
                wordsMap.put(key, synonyms);
            }
            wordsMap.get(key).add(synonym);
        }
        for (Map.Entry<String, List<String>> entry : wordsMap.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }
    }
}
