package FinalExam;

import java.util.Scanner;

public class P01DecryptingCommands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder inputText = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Finish")) {
            if (command.contains("Replace")) {
                String[] replaceCommand = command.split("\\s+");
                String oldSymbol = replaceCommand[1];
                String newSymbol = replaceCommand[2];
                String result = String.valueOf(inputText);
                inputText = new StringBuilder(result.replaceAll(oldSymbol, newSymbol));
                System.out.println(inputText);

            } else if (command.contains("Cut")) {
                String[] cutCommand = command.split("\\s+");
                int firstIndex = Integer.parseInt(cutCommand[1]);
                int lastIndex = Integer.parseInt(cutCommand[2]) + 1;

                if (firstIndex >= 0 && firstIndex <= inputText.length() && lastIndex >= 0 && lastIndex <= inputText.length()) {
                    inputText.delete(firstIndex, lastIndex);
                    System.out.println(inputText);
                } else {
                    System.out.println("Invalid indices!");
                }

            } else if (command.contains("Make")) {
                String[] makeCommand = command.split("\\s+");
                if (makeCommand[1].equals("Upper")) {
                    String result = String.valueOf(inputText).toUpperCase();
                    inputText = new StringBuilder(result);
                    System.out.println(inputText);

                } else if (makeCommand[1].equals("Lower")) {
                    String result = String.valueOf(inputText).toLowerCase();
                    inputText = new StringBuilder(result);
                    System.out.println(inputText);
                }

            } else if (command.contains("Check")) {
                String result = String.valueOf(inputText);
                String[] checkCommand = command.split("\\s+");
                String symbolToCheck = checkCommand[1];
                if (result.contains(symbolToCheck)) {
                    System.out.println("Message contains " + symbolToCheck);
                } else {
                    System.out.println("Message doesn't contain " + symbolToCheck);
                }

            } else if (command.contains("Sum")) {
                String[] sumCommand = command.split("\\s+");
                int firstIndex = Integer.parseInt(sumCommand[1]);
                int lastIndex = Integer.parseInt(sumCommand[2]) + 1;

                if (firstIndex >= 0 && firstIndex <= inputText.length() && lastIndex >= 0 && lastIndex <= inputText.length()) {
                    int charSum = 0;
                    String result = String.valueOf(inputText.substring(firstIndex, lastIndex));
                    for (int i = 0; i < result.length(); i++) {
                        char currentChar = result.charAt(i);
                        charSum += currentChar;
                    }
                    System.out.println(charSum);
                } else {
                    System.out.println("Invalid indices!");
                }
            }
            command = scanner.nextLine();
        }
    }
}
