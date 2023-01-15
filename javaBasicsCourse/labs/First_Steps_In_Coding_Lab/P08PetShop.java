package First_Steps_In_Coding_Lab;

import java.util.Scanner;

public class P08PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dogs = Integer.parseInt(scanner.nextLine());
        int cats = Integer.parseInt(scanner.nextLine());
        double totalSumDogs = dogs * 2.5;
        double totalSumCats = cats * 4.0;
        double totalsum = totalSumCats + totalSumDogs;
        System.out.println(totalsum + " lv.");
    }
}

