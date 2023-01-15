package S8_Text_Processing;

import java.util.Scanner;

public class P03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split("\\\\");

        if (inputArr[inputArr.length - 1].contains(".")) {
            String file = inputArr[inputArr.length - 1];
            String[] fileNameArr = file.split("\\.");
            System.out.println("File name: " + fileNameArr[0]);
            System.out.println("File extension: " + fileNameArr[1]);
        }
    }
}
