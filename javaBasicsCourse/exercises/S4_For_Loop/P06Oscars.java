package S4_For_Loop;

import java.util.Scanner;

public class P06Oscars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String actor = scanner.nextLine();
        double startingPoints = Double.parseDouble(scanner.nextLine());
        int evaluativeNum = Integer.parseInt(scanner.nextLine());

        double collectedPoints = startingPoints;

        for (int i = 1; i <= evaluativeNum ; i++) {
            String evaluativePerson = scanner.nextLine();
            double givenPoints = Double.parseDouble(scanner.nextLine());
            int nameLength = evaluativePerson.length();
            collectedPoints = collectedPoints + ((nameLength * givenPoints) /2);
            if (collectedPoints >= 1250.50){
                break;
            }
        }
        if (collectedPoints >= 1250.50){
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!",actor, collectedPoints );
        } else {
            double diff = 1250.50 - collectedPoints;
            System.out.printf("Sorry, %s you need %.1f more!", actor, diff);
        }
    }
}
