package S5_Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsCount = Integer.parseInt(scanner.nextLine());
        List<String> guestList = new ArrayList<>();

        for (int i = 0; i < commandsCount; i++) {
            String inputs = scanner.nextLine();
            String[] inputArr = inputs.split(" ");

            if (inputs.contains("is going!")) {
                if (guestList.contains(inputArr[0])) {
                    System.out.println(inputArr[0] + " is already in the list!");
                } else {
                    guestList.add(inputArr[0]);
                }
            } else if (inputs.contains("is not going!")) {
                if (guestList.contains(inputArr[0])) {
                    guestList.remove(String.valueOf(inputArr[0]));
                } else {
                    System.out.println(inputArr[0] + " is not in the list!");
                }
            }
        }
        for (int i = 0; i < guestList.size(); i++) {
            System.out.println(guestList.get(i));
        }
    }
}
