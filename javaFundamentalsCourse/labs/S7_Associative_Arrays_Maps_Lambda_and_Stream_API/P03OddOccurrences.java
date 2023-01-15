package S7_Associative_Arrays_Maps_Lambda_and_Stream_API;

import java.util.*;

public class P03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split("\\s+");

        LinkedHashMap<String, Integer> wordsMap = new LinkedHashMap<>();

        for (int i = 0; i < inputArr.length; i++) {
            String word = inputArr[i].toLowerCase();

            if (!wordsMap.containsKey(word)) {
                wordsMap.put(word, 1);
            } else {
                int currentValue = wordsMap.get(word);
                wordsMap.put(word, currentValue + 1);
            }
        }

        List<String> resultList = new ArrayList<>();
        for (Map.Entry<String, Integer> element : wordsMap.entrySet()) {
            if (element.getValue() % 2 != 0) {
                resultList.add(String.valueOf(element.getKey()));
            }
        }
        System.out.println(String.join(", ", resultList));
    }
}
