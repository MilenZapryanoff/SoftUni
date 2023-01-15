package S3_Arrays;

import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfWagons = Integer.parseInt(scanner.nextLine());

        int[] numbersArr = new int[numberOfWagons];

        int sum = 0;
        for (int i = 0; i < numberOfWagons; i++) {
            numbersArr[i] = Integer.parseInt(scanner.nextLine());
            sum += numbersArr[i];
            System.out.print(numbersArr[i] + " ");
        }
        System.out.println("");
        System.out.println(sum);
    }
}
