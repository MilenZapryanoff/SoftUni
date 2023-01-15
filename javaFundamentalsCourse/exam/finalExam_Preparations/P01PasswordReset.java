package FinalExam_Preparations;

import java.util.Scanner;

public class P01PasswordReset {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder password = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Done")) {
            if (command.equals("TakeOdd")) {
                int cycles = password.length();
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < cycles; i++) {
                    if (i % 2 == 0) {
                        continue;
                    } else {
                        char currentChar = password.charAt(i);
                        result.append(currentChar);
                    }
                }
                password = result;
                System.out.println(password);

            } else if (command.contains("Cut")) {
                String[] cutCommand = command.split("\\s+");
                int firstIndex = Integer.parseInt(cutCommand[1]);
                int lastIndex = firstIndex + Integer.parseInt(cutCommand[2]);
                password.delete(firstIndex, lastIndex);
                System.out.println(password);

            } else if (command.contains("Substitute")) {

                String[] substituteCommand = command.split("\\s+");
                String digitToRemove = substituteCommand[1];
                String digitToReplace = substituteCommand[2];

                if (!String.valueOf(password).contains(digitToRemove)) {
                    System.out.println("Nothing to replace!");
                } else {
                    while (String.valueOf(password).contains(digitToRemove)) {
                        int firstIndex = password.indexOf(digitToRemove);
                        int secondIndex = password.indexOf(digitToRemove) + digitToRemove.length();
                        password.replace(firstIndex, secondIndex, digitToReplace);
                    }
                    System.out.println(password);
                }
            }
            command = scanner.nextLine();
        }
        System.out.println("Your password is: " + password);
    }
}
