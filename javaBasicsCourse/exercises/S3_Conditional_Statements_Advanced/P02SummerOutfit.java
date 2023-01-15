package S3_Conditional_Statements_Advanced;

import java.util.Scanner;

public class P02SummerOutfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degrees = Integer.parseInt(scanner.nextLine());
        String daytime = scanner.nextLine();

        String outfit = "";
        String shoes = "";

        if (daytime.equals("Morning")){
            if ((degrees >= 10 && degrees <= 18)){
                outfit = "Sweatshirt";
                shoes = "Sneakers";
            } else if ((degrees > 18 && degrees <= 24)){
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if (degrees >= 25){
                outfit = "T-Shirt";
                shoes = "Sandals";
            }
        } else if (daytime.equals("Afternoon")) {
            if ((degrees >= 10 && degrees <= 18)){
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if ((degrees > 18 && degrees <= 24)){
                outfit = "T-Shirt";
                shoes = "Sandals";
            } else if (degrees >= 25){
                outfit = "Swim Suit";
                shoes = "Barefoot";
            }
        } else if (daytime.equals("Evening")) {
            if ((degrees >= 10 && degrees <= 18)){
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if ((degrees > 18 && degrees <= 24)){
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if (degrees >= 25){
                outfit = "Shirt";
                shoes = "Moccasins";
            }
        }
        System.out.printf("It's %s degrees, get your %s and %s.",degrees, outfit, shoes);
    }
}
