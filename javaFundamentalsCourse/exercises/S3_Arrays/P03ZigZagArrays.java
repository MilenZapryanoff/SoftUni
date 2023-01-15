package S3_Arrays;

import java.util.Scanner;

public class P03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        String[] firstLineArr = new String[input];
        String[] secondLineArr = new String[input];

        int firstLineCounter = 0;
        int secondLineCounter = 1;
        for (int i = 0; i < input; i++) {
            String[] inputArr = scanner.nextLine().split(" ");

            firstLineArr[i] = inputArr[firstLineCounter];
            secondLineArr[i] = inputArr[secondLineCounter];
            firstLineCounter++;
            secondLineCounter--;

            if (firstLineCounter > 1) {
                firstLineCounter = 0;
                secondLineCounter = 1;
            }
        }
        System.out.println(String.join(" ", firstLineArr));
        System.out.println(String.join(" ", secondLineArr));
    }
}
