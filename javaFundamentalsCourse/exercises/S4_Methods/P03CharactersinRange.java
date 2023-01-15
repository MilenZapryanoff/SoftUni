package S4_Methods;

import java.util.Scanner;

public class P03CharactersinRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstSymbol = scanner.nextLine().charAt(0);
        char secondSymbol = scanner.nextLine().charAt(0);
        printCharacters(firstSymbol, secondSymbol);

    }

    public static void printCharacters(char firstSymbol, char secondSymbol) {
        if (firstSymbol < secondSymbol) {
            for (int i = firstSymbol + 1; i < secondSymbol; i++) {
                char currentSymbol = (char) i;
                System.out.print(currentSymbol + " ");
            }
        } else if (firstSymbol > secondSymbol) {
            for (int i = secondSymbol + 1; i < firstSymbol; i++) {
                char currentSymbol = (char) i;
                System.out.print(currentSymbol + " ");
            }
        }
    }
}