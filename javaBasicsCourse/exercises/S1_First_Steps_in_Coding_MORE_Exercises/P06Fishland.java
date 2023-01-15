package S1_First_Steps_in_Coding_MORE_Exercises;

import java.util.Scanner;

public class P06Fishland {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

    double skumriyaPrice = Double.parseDouble(scanner.nextLine());
    double cacaPrice = Double.parseDouble(scanner.nextLine());
    double palamud = Double.parseDouble(scanner.nextLine());
    double safrid = Double.parseDouble(scanner.nextLine());
    int midi = Integer.parseInt(scanner.nextLine());

    double palamudPrice = skumriyaPrice + (skumriyaPrice * 0.60);
    double safridPrice = cacaPrice + (cacaPrice * 0.80);
    double midiPrice = 7.5;

    double totalPrice = (palamud * palamudPrice) + (safrid * safridPrice) + (midi * midiPrice);
    System.out.printf("%.2f", totalPrice);

    }
}
