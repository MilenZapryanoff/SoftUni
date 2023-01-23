package S3_Sets_and_Maps_Advanced;

import java.util.*;

public class P03VoinaNumbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> deckOne = new LinkedHashSet<>();
        LinkedHashSet<Integer> deckTwo = new LinkedHashSet<>();

        String[] firstPlayerCards = scanner.nextLine().split("\\s+");
        for (String cards : firstPlayerCards) {
            deckOne.add(Integer.parseInt(cards));
        }
        String[] secondPlayerCards = scanner.nextLine().split("\\s+");
        for (String cards : secondPlayerCards) {
            deckTwo.add(Integer.parseInt(cards));
        }

        for (int i = 0; i < 50; i++) {
            if (deckOne.isEmpty()) {
                break;
            } else if (deckTwo.isEmpty()) {
                break;
            }
            Integer fighterOne = deckOne.iterator().next();
            Integer fighterTwo = deckTwo.iterator().next();

            deckOne.remove(fighterOne);
            deckTwo.remove(fighterTwo);

            if (fighterOne > fighterTwo) {
                deckOne.add(fighterOne);
                deckOne.add(fighterTwo);
            } else if (fighterTwo > fighterOne) {
                deckTwo.add(fighterOne);
                deckTwo.add(fighterTwo);
            }

        }

        if (deckOne.size() < deckTwo.size()) {
            System.out.println("Second player win!");
        } else if (deckTwo.size() < deckOne.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
