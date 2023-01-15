package S7_Associative_Arrays_Maps_Lambda_and_Stream_API;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, String> parkingMap = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String[] commandArr = scanner.nextLine().split("\\s+");

            if (commandArr[0].equals("register")) {
                String name = commandArr[1];
                String licencePlate = commandArr[2];

                if (!parkingMap.containsKey(name)) {
                    parkingMap.put(name, licencePlate);
                    System.out.printf("%s registered %s successfully%n", name, licencePlate);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", licencePlate);
                }
            } else if (commandArr[0].equals("unregister")) {
                String name = commandArr[1];

                if (!parkingMap.containsKey(name)) {
                    System.out.printf("ERROR: user %s not found%n", name);
                } else {
                    parkingMap.remove(name);
                    System.out.printf("%s unregistered successfully%n", name
                    );
                }
            }
        }
        for (Map.Entry<String, String> entry : parkingMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

    }
}
