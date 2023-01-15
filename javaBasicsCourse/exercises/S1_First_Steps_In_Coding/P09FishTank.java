package S1_First_Steps_In_Coding;

import java.util.Scanner;

public class P09FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lenght = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int heigh = Integer.parseInt(scanner.nextLine());
        Double percentage = Double.parseDouble(scanner.nextLine());

        int volume = lenght * width * heigh;
        Double volumeLtr = volume / 1000.00;
        Double percentagecalc = percentage/100.00;
        Double totalLtr = volumeLtr * (1-percentagecalc);
        System.out.println(totalLtr);
    }
}
