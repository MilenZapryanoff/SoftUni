package EXAM;

import java.util.Scanner;

public class P05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int highReached = 5364;
        int dayCounter = 1;

        while (!input.equals("END")) {

            int metersClimbed = Integer.parseInt(scanner.nextLine());

            if (input.equals("Yes")) {
                dayCounter++;
            }
            if (dayCounter > 5) {
                break;
            }

            highReached = highReached + metersClimbed;

            if (highReached >= 8848) {
                break;
            }

            input = scanner.nextLine();
        }

            if (highReached >= 8848) {
                System.out.printf("Goal reached for %d days!", dayCounter);
            } else {
                System.out.println("Failed!");
                System.out.printf("%d", highReached);
            }
        }
    }
