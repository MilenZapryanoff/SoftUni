package S1_First_Steps_In_Coding;

import java.util.Scanner;

public class P03DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//varialbles
        Double deposit = Double.parseDouble(scanner.nextLine());
        int period = Integer.parseInt(scanner.nextLine());
        Double interest = Double.parseDouble(scanner.nextLine());
//calculations
        Double totalInterest = deposit * interest/100;
        Double monthlyInterest = totalInterest/12;
        Double totalAmount = deposit + monthlyInterest * period;
        System.out.println(totalAmount);
    }
}
