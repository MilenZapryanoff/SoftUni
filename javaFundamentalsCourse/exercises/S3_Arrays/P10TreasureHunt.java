package S3_Arrays;

import java.util.Scanner;

public class P10TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] chestArr = scanner.nextLine().split("\\|");
        String command = scanner.nextLine();

        while (!command.equals("Yohoho!")){
            String[] commandArr = command.split(" ");

            if (command.contains("Loot")){
                for (int i = 1; i < commandArr.length; i++) {
                    boolean alreadyContained = false;
                    for (int j = 0; j < chestArr.length; j++) {
                        if (commandArr[i].equals(chestArr[j])) {
                            alreadyContained = true;
                            break;
                        }
                    }
                    if (!alreadyContained) {
                        String newChest = commandArr[i] + " " + String.join(" ", chestArr);
                        chestArr = newChest.split(" ");
                    }
                }
            } else if (command.contains("Drop")) {
                if (Integer.parseInt(commandArr[1]) >= 0 && Integer.parseInt(commandArr[1]) <= chestArr.length -1  ){
                String lastSymbol = chestArr[Integer.parseInt(commandArr[1])];
                for (int i = Integer.parseInt(commandArr[1]); i < chestArr.length - 1; i++) {
                    chestArr[i] = chestArr[i+1];
                }
                chestArr[chestArr.length-1] = lastSymbol;
                }
            } else if (command.contains("Steal ")) {
                int numberOfStealingItems = Integer.parseInt(commandArr[1]);

                if (numberOfStealingItems >= 0 && numberOfStealingItems < chestArr.length) {
                    for (int i = 0; i < numberOfStealingItems; i++) {
                        System.out.print(chestArr[chestArr.length - numberOfStealingItems + i]);
                        if (i != numberOfStealingItems - 1) {
                            System.out.print(", ");
                        }
                    }
                    String[] tempChest = new String[chestArr.length - numberOfStealingItems];
                    for (int i = 0; i < tempChest.length; i++) {
                        tempChest[i] = chestArr[i];
                    }
                    chestArr = tempChest;

                } else if (numberOfStealingItems >= 0) {
                    for (int i = 0; i < chestArr.length; i++) {
                        System.out.print(chestArr[i]);
                        if (i != chestArr.length - 1) {
                            System.out.print(", ");
                        }
                    }
                    chestArr = new String[0];
                }
                System.out.println();
            }
            command = scanner.nextLine();
        }
        String treasureCount = String.join("", chestArr);
        int charCounter = 0;
        for (int i = 0; i < treasureCount.length(); i++) {
            charCounter++;
        }
        double averageTreasure = (1.0 * charCounter) / chestArr.length;
        if (charCounter > 0) {
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasure);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
