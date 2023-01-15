package EXAM;

import java.util.Scanner;

public class P02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double partyPrice = Double.parseDouble(scanner.nextLine());
        int loveMessages = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int keyholders = Integer.parseInt(scanner.nextLine());
        int caricatures = Integer.parseInt(scanner.nextLine());
        int surprises = Integer.parseInt(scanner.nextLine());

        double loveMessagesSum = loveMessages * 0.60;
        double rosesSum = roses * 7.20;
        double keyholdersSum = keyholders * 3.60;
        double caricaturesSum = caricatures * 18.20;
        double surprisesSum = surprises * 22.0;

        double sum = loveMessagesSum + rosesSum + keyholdersSum + caricaturesSum + surprisesSum;
        int totalCount = loveMessages + roses + keyholders + caricatures + surprises;

        if (totalCount >= 25){
            sum = sum - (sum * 0.35);
        }
        double totalSum = sum - (sum * 0.10);

        if (totalSum >= partyPrice)
            System.out.printf("Yes! %.2f lv left.", totalSum - partyPrice);
        else {
            System.out.printf("Not enough money! %.2f lv needed.", partyPrice - totalSum);
        }
    }
}
