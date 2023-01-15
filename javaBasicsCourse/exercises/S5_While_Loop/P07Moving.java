package S5_While_Loop;

import java.util.Scanner;

public class P07Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int high = Integer.parseInt(scanner.nextLine());

        int totalSpace = width * length * high;
        int spaceTaken = 0;
        int spaceLeft = 0;


        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            int currentNum = Integer.parseInt(input);
            spaceTaken = spaceTaken + currentNum;
            spaceLeft = totalSpace - spaceTaken;
            if (spaceLeft < 0) {
                break;
            }
            input = scanner.nextLine();
        }
        if (spaceLeft < 0) {
            System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(spaceLeft));
        } else {
            System.out.printf("%d Cubic meters left.", spaceLeft);
        }
    }
    }
