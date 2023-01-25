package S3_Sets_and_Maps_Advanced;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cycles = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < cycles; i++) {
            String input = scanner.nextLine();
            usernames.add(input);
        }

        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
