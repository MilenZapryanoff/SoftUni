package S1_First_Steps_In_Coding;

import java.util.Scanner;

public class P06Repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int naylon = Integer.parseInt(scanner.nextLine()); //количество найлон
        int paint = Integer.parseInt(scanner.nextLine()); //количество боя
        int alcohol = Integer.parseInt(scanner.nextLine()); //количество разредител
        int hours = Integer.parseInt(scanner.nextLine()); //часове майстори

        Double nayloneSum = (naylon + 2) * 1.5;
        Double paintSum = paint * 14.50;
        Double paintSumAdd = paintSum + paintSum *10/100;
        Double alcoholSum = alcohol * 5.0;
        Double packageSum = 0.4;
        Double totalSum = nayloneSum + paintSumAdd + alcoholSum + packageSum;
        Double labor = (totalSum * 30/100) * hours;
        Double grandTotal = totalSum + labor;

        System.out.println(grandTotal);





    }
}
