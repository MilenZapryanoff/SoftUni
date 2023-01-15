package S8_Text_Processing_additional;

import java.util.Scanner;

public class P01ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            String[] resultArr = new String[2];
            String input = scanner.nextLine();

            int nameFirstIndex = input.indexOf("@");
            int nameLastIndex = input.indexOf("|");
            resultArr[0] = input.substring(nameFirstIndex + 1, nameLastIndex);

            int ageFirstIndex = input.indexOf("#");
            int ageLastIndex = input.indexOf("*");
            resultArr[1] = input.substring(ageFirstIndex + 1, ageLastIndex);

            System.out.printf("%s is %s years old.%n", resultArr[0], resultArr[1]);
        }
    }
}
