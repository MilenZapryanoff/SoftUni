package S4_For_Loop;

import java.util.Scanner;

public class P07TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groups = Integer.parseInt(scanner.nextLine());

        int musala = 0;
        int monblan = 0;
        int kilimandjaro = 0;
        int k2 = 0;
        int everest = 0;


        for (int i = 1; i <= groups; i++) {
            int people = Integer.parseInt(scanner.nextLine());
            if (people <= 5){
                musala = musala + people;
            } else if (people <= 12) {
                monblan = monblan + people;
            } else if (people <= 25) {
                kilimandjaro = kilimandjaro + people;
            } else if (people <= 40) {
                k2 = k2 + people;
            } else {
                everest = everest + people;
            }
        }
        double totalPeople = musala + monblan + kilimandjaro + k2 + everest;

        System.out.printf("%.2f%%%n", musala / totalPeople * 100.00);
        System.out.printf("%.2f%%%n", monblan / totalPeople * 100);
        System.out.printf("%.2f%%%n", kilimandjaro / totalPeople * 100);
        System.out.printf("%.2f%%%n", k2 / totalPeople * 100);
        System.out.printf("%.2f%%%n", everest / totalPeople * 100);
    }
}
