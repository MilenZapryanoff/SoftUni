package First_Steps_In_Coding_Lab;

import java.util.Scanner;

public class P09YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double sqm = Double.parseDouble(scanner.nextLine());
        Double sqmPrice = sqm * 7.61;
        Double discount = sqmPrice * 0.18;
        Double priceWithDiscoint = sqmPrice - discount;
                System.out.println("The final price is: " + priceWithDiscoint + " lv.");
                System.out.println("The discount is: " + discount + " lv.");



        //"The final price is: {крайна цена на услугата} lv."
        //"The discount is: {отстъпка} lv."
    }
}
