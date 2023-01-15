package S1_First_Steps_in_Coding_MORE_Exercises;

import java.util.Scanner;

public class P05TrainingLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double w = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double totalH = h * 100 - 100;
        //брой бюра по ширина
        int descsH = (int) (totalH / 70);

        double totalW = w * 100;
        int descsRows = (int) (totalW / 120);

        double totalPlaces = descsRows * descsH - 3;

      System.out.printf("%.0f", totalPlaces);





    }
}
