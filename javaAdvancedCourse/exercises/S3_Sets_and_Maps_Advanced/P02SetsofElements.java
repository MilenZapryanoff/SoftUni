package S3_Sets_and_Maps_Advanced;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class P02SetsofElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> setOne = new LinkedHashSet<>();
        LinkedHashSet<Integer> setTwo = new LinkedHashSet<>();

        String[] setLength = scanner.nextLine().split("\\s+");
        int firstSetLength = Integer.parseInt(setLength[0]);
        int secondSetLength = Integer.parseInt(setLength[1]);

        //попълваме първи сет
        for (int i = 0; i < firstSetLength; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            setOne.add(input);
        }
        //попълваме втори сет
        for (int i = 0; i < secondSetLength; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            setTwo.add(input);
        }

        //обхождаме сет1
        for (int s : setOne) {
            if (setTwo.contains(s)) {
                System.out.print(s + " ");
            }
        }

//            алтернативен вариант
//        setOne.retainAll(setTwo);
//        setOne.forEach(element -> System.out.println());
    }
}
