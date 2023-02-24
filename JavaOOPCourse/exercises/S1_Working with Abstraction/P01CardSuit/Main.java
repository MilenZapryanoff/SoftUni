package S1_Working_with_Abstraction.P01CardSuit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");
        CardSuits[] values = CardSuits.values();
        for (CardSuits value : values) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", value.ordinal(), value.name());
        }
    }

    enum CardSuits {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES

    }
}
