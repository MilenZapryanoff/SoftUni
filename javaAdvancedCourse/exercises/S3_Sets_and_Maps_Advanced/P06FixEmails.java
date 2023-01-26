package S3_Sets_and_Maps_Advanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> phonebook = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();
            //проверка на мейла
            if (email.contains(".us") || email.contains(".uk") || email.contains(".com")) {
                input = scanner.nextLine();
                continue;
            } else {
                phonebook.put(name, email);
            }
            input = scanner.nextLine();
        }
        //изчитане и печат на мапа
        for (Map.Entry<String, String> entry : phonebook.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
