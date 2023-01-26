package S3_Sets_and_Maps_Advanced;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P07HandsOfCards {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, HashMap<String, Integer>> cardsMap = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {

            String[] inputLine = input.split(":");
            String name = inputLine[0];
            String[] cards = inputLine[1].trim().split(", ");

            //добавяне на името
            if (!cardsMap.containsKey(name)) {
                cardsMap.put(name, new HashMap<>());
            }

            HashMap<String, Integer> innerMap = cardsMap.get(name);

            String currentCard;

            //итериране по масива с карти
            for (int i = 0; i < cards.length; i++) {
                currentCard = cards[i];
                calculateCardPower(currentCard); //изполване на метод за изчисляване на Power-а на картата

                if (!cardsMap.get(name).containsKey(currentCard)) {
                    innerMap.put(currentCard, calculateCardPower(currentCard));
                }
            }
            input = scanner.nextLine();
        }

        //итериране по записите на външния масив
        for (String name : cardsMap.keySet()) {
            System.out.print(name + ": ");

            //създаване на вътрешния масив и итериране по записите му за да се калкулират всички карти
            Map<String, Integer> innerMap = cardsMap.get(name);
            int totalSum = 0;
            for (String card : innerMap.keySet()) {
                totalSum = totalSum + innerMap.get(card);
            }
            System.out.println(totalSum);
        }

    }

    private static int calculateCardPower(String currentCard) {
        int cardPower = 0;
        int cardType = 0;
        int totalCardPower;

        if (currentCard.length() == 2) {
            switch (String.valueOf(currentCard.charAt(0))) {
                case "J":
                    cardPower = 11;
                    break;
                case "Q":
                    cardPower = 12;
                    break;
                case "K":
                    cardPower = 13;
                    break;
                case "A":
                    cardPower = 14;
                    break;
                default: {
                    cardPower = Integer.parseInt(String.valueOf(currentCard.charAt(0)));
                }
            }
            switch (String.valueOf(currentCard.charAt(1))) {
                case "S":
                    cardType = 4;
                    break;
                case "H":
                    cardType = 3;
                    break;
                case "D":
                    cardType = 2;
                    break;
                case "C":
                    cardType = 1;
                    break;
            }
        } else if (currentCard.length() == 3) {
            cardPower = 10;
            if (String.valueOf(currentCard.charAt(2)).equals("S")) {
                cardType = 4;
            } else if (String.valueOf(currentCard.charAt(2)).equals("H")) {
                cardType = 3;
            } else if (String.valueOf(currentCard.charAt(2)).equals("D")) {
                cardType = 2;
            } else if (String.valueOf(currentCard.charAt(2)).equals("C")) {
                cardType = 1;
            }
        }
        totalCardPower = cardPower * cardType;
        return totalCardPower;
    }
}
