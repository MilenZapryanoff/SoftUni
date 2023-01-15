package S4_For_Loop;

import java.util.Scanner;

public class P03Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double p1 = 0; //< 200
        double p2 = 0; //200 … 399
        double p3 = 0; //400 … 599
        double p4 = 0; //600 … 799
        double p5 = 0; //≥ 800


        for (int i = 1; i <= n ; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            if (currentNum < 200){
                p1++;
            } else if (currentNum < 400) {
                p2++;
            } else if (currentNum < 600) {
                p3++;
            } else if (currentNum < 800) {
                p4++;
            } else {
                p5++;
            }
        }
        System.out.printf("%.2f%%%n",p1 / n * 100);
        System.out.printf("%.2f%%%n",p2 / n * 100);
        System.out.printf("%.2f%%%n",p3 / n * 100);
        System.out.printf("%.2f%%%n",p4 / n * 100);
        System.out.printf("%.2f%%%n",p5 / n * 100);
    }
}
