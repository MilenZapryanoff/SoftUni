package MidExam_Preparations;

import java.util.Scanner;

public class P01GuineaPig {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double food = Double.parseDouble(scanner.nextLine()) * 1000;
        double hay = Double.parseDouble(scanner.nextLine()) * 1000;
        double cover = Double.parseDouble(scanner.nextLine()) * 1000;
        double weight = Double.parseDouble(scanner.nextLine()) * 1000;

        printResult(food, hay, cover, weight);
    }

    public static void printResult(double food, double hay, double cover, double weight) {
        boolean notEnoughProducts = false;

        for (int day = 1; day <= 30; day++) {
            food = food - 300;
            if (food <= 0) {
                notEnoughProducts = true;
                break;
            }
            if (day % 2 == 0) {
                hay = hay - (food * 0.05);
                if (hay <= 0) {
                    notEnoughProducts = true;
                    break;
                }
            }
            if (day % 3 == 0) {
                cover = cover - (weight / 3);
                if (cover <= 0) {
                    notEnoughProducts = true;
                    break;
                }
            }
        }
        if (!notEnoughProducts) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.%n", food / 1000, hay / 1000, cover / 1000);
        } else {
            System.out.println("Merry must go to the pet store! ");
        }
    }
}
