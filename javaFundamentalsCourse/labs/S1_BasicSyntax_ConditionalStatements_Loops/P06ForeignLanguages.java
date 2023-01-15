package S1_BasicSyntax_ConditionalStatements_Loops;

import java.util.Scanner;

public class P06ForeignLanguages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();

        if (country.equals("England") || country.equals("USA")){
            System.out.println("English");
        } else if (country.equals("Spain") || country.equals("Argentina") || country.equals("Mexico")) {
            System.out.println("Spanish ");
        } else {
            System.out.println("unknown");
        }

    }
}
