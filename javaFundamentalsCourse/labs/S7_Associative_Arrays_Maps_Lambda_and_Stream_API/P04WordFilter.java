package S7_Associative_Arrays_Maps_Lambda_and_Stream_API;

import java.util.Arrays;
import java.util.Scanner;

public class P04WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] wordsArr = Arrays.stream(scanner.nextLine().split("\\s+")).filter(e -> e.length() % 2 == 0).toArray(String[]::new);

        for (int i = 0; i < wordsArr.length; i++) {
            System.out.println(wordsArr[i]);
        }
    }
}
