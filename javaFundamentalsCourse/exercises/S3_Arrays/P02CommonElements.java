package S3_Arrays;

import java.util.Scanner;

public class P02CommonElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] firstLineArr = scanner.nextLine().split(" ");
        String[] secondLineArr = scanner.nextLine().split(" ");

        for (int i = 0; i < secondLineArr.length; i++) {
            for (int j = 0; j < firstLineArr.length; j++) {

                if (secondLineArr[i].equals(firstLineArr[j])) {
                    System.out.print(secondLineArr[i] + " ");
                }
            }
        }
    }
}
