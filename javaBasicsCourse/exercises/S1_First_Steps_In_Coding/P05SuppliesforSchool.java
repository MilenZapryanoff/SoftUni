package S1_First_Steps_In_Coding;

import java.util.Scanner;

public class P05SuppliesforSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pen = Integer.parseInt(scanner.nextLine());
        int marker = Integer.parseInt(scanner.nextLine());
        int cleaner = Integer.parseInt(scanner.nextLine());
        int discount = Integer.parseInt(scanner.nextLine());

        Double penPrice = pen * 5.80;
        Double markerPrice = marker * 7.20;
        Double cleanerPrice = cleaner * 1.20;
        Double totalPrice = penPrice + markerPrice + cleanerPrice;
        Double discountSum = totalPrice * discount/100;
        System.out.println(totalPrice - discountSum);
    }
}
