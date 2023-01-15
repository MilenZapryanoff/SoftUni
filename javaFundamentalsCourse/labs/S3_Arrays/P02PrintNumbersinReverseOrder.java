package S3_Arrays;

import java.util.Scanner;

public class P02PrintNumbersinReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input  = Integer.parseInt(scanner.nextLine());

        int[] numberArr = new int[input];

        for (int i = 0; i < numberArr.length; i++) {
            numberArr[i] = Integer.parseInt(scanner.nextLine());;
        }

        for (int i = numberArr.length -1; i >= 0 ; i--) {
            System.out.print(numberArr[i] + " ");
        }


    }
}
