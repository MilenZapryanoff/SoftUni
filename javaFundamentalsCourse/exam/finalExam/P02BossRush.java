package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02BossRush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cycles = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cycles; i++) {
            boolean isValid = false;
            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile("[\\|](?<name>[A-Z]{4,})[\\|]:[#](?<title>[A-Za-z]+\\s[A-Za-z]+)[#]");
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                isValid = true;
                String name = matcher.group("name");
                String title = matcher.group("title");
                int strength = name.length();
                int armor = title.length();

                System.out.printf("%s, The %s%n", name, title);
                System.out.printf(">> Strength: %d%n", strength);
                System.out.printf(">> Armor: %d%n", armor);
            }

            if (!isValid) {
                System.out.println("Access denied!");
            }
        }
    }
}
