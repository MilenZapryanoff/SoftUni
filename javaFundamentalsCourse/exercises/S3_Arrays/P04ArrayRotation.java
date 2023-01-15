package S3_Arrays;

import java.util.Scanner;
import java.util.SimpleTimeZone;

public class P04ArrayRotation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] numbersArr = scanner.nextLine().split(" ");
        int rotations = Integer.parseInt(scanner.nextLine());

        String lastSymbol = "";
        for (int i = 0; i < rotations; i++) {
            lastSymbol = numbersArr[0];
            for (int j = 0; j < numbersArr.length - 1; j++) {
                numbersArr[j] = numbersArr[j + 1];
            }
            numbersArr[numbersArr.length - 1] = lastSymbol;
        }
        System.out.println(String.join(" ", numbersArr));

    }
}
