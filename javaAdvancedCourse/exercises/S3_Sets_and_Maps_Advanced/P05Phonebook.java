package S3_Sets_and_Maps_Advanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> contactsMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String[] contacts = input.split("-");
            String name = contacts[0];
            String number = contacts[1];

            contactsMap.put(name, number);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("stop")) {

            if (contactsMap.containsKey(input)) {
                System.out.println(input + " -> " + contactsMap.get(input));
            } else {
                System.out.println("Contact " + input + " does not exist.");
            }
            input = scanner.nextLine();
        }
    }
}
