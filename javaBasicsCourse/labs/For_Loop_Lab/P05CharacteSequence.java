package For_Loop_Lab;

import java.util.Scanner;

public class P05CharacteSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine();

        for (int i = 0; i < inputText.length(); i++) {
            char symbol = inputText.charAt(i);
            System.out.println(symbol);
                }

    }
}
