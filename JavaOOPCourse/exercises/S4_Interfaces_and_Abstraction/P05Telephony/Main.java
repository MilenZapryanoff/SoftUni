package S4_Interfaces_and_Abstraction.P05Telephony;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersInput = scanner.nextLine().split("\\s+");
        List<String> numbers = List.of(numbersInput);

        String[] urlsInput = scanner.nextLine().split("\\s+");
        List<String> urls = List.of(urlsInput);

        Smartphone smartphone = new Smartphone(numbers, urls);
        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}