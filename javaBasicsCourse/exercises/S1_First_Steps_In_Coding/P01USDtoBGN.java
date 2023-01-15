package S1_First_Steps_In_Coding;

import java.util.Scanner;

public class P01USDtoBGN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double usd = Double.parseDouble(scanner.nextLine());
        Double bgn = usd * 1.79549;
        System.out.println(bgn);

    }
}

