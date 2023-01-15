package Conditional_Statements_Advanced_Lab;

import java.util.Scanner;

public class P09FruitorVegetable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String prduct = scanner.nextLine();

        switch (prduct){
            case "banana":
            case "apple":
            case "kiwi":
            case "cherry":
            case "lemon":
            case "grapes":
                System.out.println("fruit");
                break;
            case "tomato":
            case "cucumber":
            case "pepper":
            case "carrot":
                System.out.println("vegetable");
                break;
            default:
                System.out.println("unknown");
                break;
        }
    }
}
