package S4_Methods;

import java.util.Scanner;

public class P05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());

        if (product.equals("coffee")){
            calculateAndPrintTotalPrice(count,1.50);
        } else if (product.equals("water")) {
            calculateAndPrintTotalPrice(count,1.0);
        } else if (product.equals("coke")) {
            calculateAndPrintTotalPrice(count,1.4);
        } else if (product.equals("snacks")) {
            calculateAndPrintTotalPrice(count,2.0);
        }

    }
    public static void calculateAndPrintTotalPrice (int count, double price){
        double totalPrice =  count * price;
        System.out.printf("%.2f", totalPrice);
    }
}
