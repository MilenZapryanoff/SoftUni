package S1_First_Steps_In_Coding;

import java.util.Scanner;

public class P07FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chicken = Integer.parseInt(scanner.nextLine());
        int fish = Integer.parseInt(scanner.nextLine());
        int vegan = Integer.parseInt(scanner.nextLine());

        Double chickenPrice = chicken * 10.35;
        Double fishPrice = fish * 12.40;
        Double veganPrice = vegan * 8.15;
        Double totalPrice = chickenPrice + fishPrice + veganPrice;
        Double desertPrice = totalPrice *20/100;
        Double grandTotal = totalPrice + desertPrice + 2.5;
        System.out.println(grandTotal);
    }
}
