package S3_Sets_and_Maps_Advanced;

import java.util.Scanner;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeSet<String> regularGuests = new TreeSet<>();
        TreeSet<String> vipGuests = new TreeSet<>();

        while (!input.equals("PARTY")) {
            char firstDigit = input.charAt(0);
            if (Character.isDigit(firstDigit)) {
                vipGuests.add(input);
            } else {
                regularGuests.add(input);
            }
            input = scanner.nextLine();
        }

        while (!input.equals("END")) {
            char firstDigit = input.charAt(0);
            if (Character.isDigit(firstDigit)) {
                vipGuests.remove(input);
            } else {
                regularGuests.remove(input);
            }
            input = scanner.nextLine();
        }

        int totalMissingGuests = vipGuests.size() + regularGuests.size();
        System.out.println(totalMissingGuests);

        for (String guest : vipGuests) {
            System.out.println(guest);
        }
        for (String guest : regularGuests) {
            System.out.println(guest);
        }
    }
}