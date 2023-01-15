package FinalExam_Preparations;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int entries = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("@#+([A-Z][A-Za-z0-9]{4,}[A-Z])@#+");
        Matcher matcher = null;


        for (int i = 0; i < entries; i++) {
            String input = scanner.nextLine();

            matcher = pattern.matcher(input);
            StringBuilder resultString = new StringBuilder();

            while (matcher.find()) {
                resultString.append(matcher.group(1));
            }

            if (resultString.length() == 0) {
                System.out.println("Invalid barcode");
                continue;
            }

            boolean containsDigit = false;
            StringBuilder productGroup = new StringBuilder();

            for (int j = 0; j < resultString.length(); j++) {
                char currentChar = resultString.charAt(j);
                if (currentChar >= 48 && currentChar <= 57) {
                    productGroup.append(currentChar);
                    containsDigit = true;
                }
            }
            if (!containsDigit) {
                System.out.println("Product group: 00");
            } else {
                System.out.printf("Product group: %s%n", productGroup);
            }
        }
    }
}

