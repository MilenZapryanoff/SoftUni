package FinalExam_Preparations;

import java.util.Scanner;

public class P01ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder activationKey = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Generate")) {
            String[] commandArr = command.split(">>>");

            if (commandArr[0].equals("Contains")) {
                String currentKey = String.valueOf(activationKey);
                if (currentKey.contains(commandArr[1])) {
                    System.out.println(currentKey + " contains " + commandArr[1]);
                } else {
                    System.out.println("Substring not found!");
                }

            } else if (commandArr[0].equals("Flip")) {
                if (commandArr[1].equals("Upper")) {
                    int firstIndex = Integer.parseInt(commandArr[2]);
                    int lastIndex = Integer.parseInt(commandArr[3]);
                    String modString = (activationKey.substring(firstIndex, lastIndex)).toUpperCase();
                    activationKey.replace(firstIndex, lastIndex, modString);
                } else if (commandArr[1].equals("Lower")) {
                    int firstIndex = Integer.parseInt(commandArr[2]);
                    int lastIndex = Integer.parseInt(commandArr[3]);
                    String modString = (activationKey.substring(firstIndex, lastIndex)).toLowerCase();
                    activationKey.replace(firstIndex, lastIndex, modString);
                }
                System.out.println(activationKey);
            } else if (commandArr[0].equals("Slice")) {
                int firstIndex = Integer.parseInt(commandArr[1]);
                int lastIndex = Integer.parseInt(commandArr[2]);
                activationKey.delete(firstIndex, lastIndex);
                System.out.println(activationKey);
            }
            command = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + activationKey);
    }
}

