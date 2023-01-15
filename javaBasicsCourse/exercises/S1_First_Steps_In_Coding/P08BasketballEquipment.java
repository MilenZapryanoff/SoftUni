package S1_First_Steps_In_Coding;

import java.util.Scanner;

public class P08BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double annualFee = Double.parseDouble(scanner.nextLine());

        Double snickers = annualFee - (annualFee * 40/100);
        Double snickersPrice = snickers - (annualFee * 40/100);
        Double set = snickers - (snickers *20/100);
        Double ball = set * 25/100;
        Double accessories = ball * 20/100;
        Double totalSum = annualFee + snickers + set + ball + accessories;
        System.out.println(totalSum);
    }
}
