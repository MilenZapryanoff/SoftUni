package S1_Working_with_Abstraction.P02CardRank;

public class Main {

    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        CardRanks[] values = CardRanks.values();
        for (CardRanks value : values) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", value.ordinal(), value.name());
        }

    }


    enum CardRanks {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING

    }
}
