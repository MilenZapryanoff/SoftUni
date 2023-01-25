package S3_Sets_and_Maps_Advanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<String, Integer> lettersMap = new TreeMap<>();

        //обхождане на стринга
        for (int i = 0; i < input.length(); i++) {
            String currentChar = String.valueOf(input.charAt(i));
            //попълване на мапа
            if (!lettersMap.containsKey(currentChar)) {
                lettersMap.put(currentChar, 1);
            } else {
                int currentFoundCount = lettersMap.get(currentChar);
                lettersMap.put(currentChar, currentFoundCount + 1);
            }
            System.out.println();
        }
        //обхождане и прин на мапа
        for (Map.Entry<String, Integer> entry : lettersMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }
    }
}

