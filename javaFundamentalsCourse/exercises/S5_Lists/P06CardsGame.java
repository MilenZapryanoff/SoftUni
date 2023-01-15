package S5_Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int minSize = Math.min(firstDeck.size(), secondDeck.size());

        while (minSize > 0) {

            int firstNum = firstDeck.get(0);
            int secondNum = secondDeck.get(0);
            firstDeck.remove(0);
            secondDeck.remove(0);

            if (firstNum > secondNum) {
                firstDeck.add(firstNum);
                firstDeck.add(secondNum);
            } else if (firstNum < secondNum) {
                secondDeck.add(secondNum);
                secondDeck.add(firstNum);
            }

            minSize = Math.min(firstDeck.size(), secondDeck.size());
        }
        int sum = 0;
        if (firstDeck.size() > 0) {
            for (Integer integer : firstDeck) {
                sum = sum + integer;
            }
            System.out.println("First player wins! Sum: " + sum);
        } else {
            for (Integer integer : secondDeck) {
                sum = sum + integer;
            }
            System.out.println("Second player wins! Sum: " + sum);
        }
    }
}
