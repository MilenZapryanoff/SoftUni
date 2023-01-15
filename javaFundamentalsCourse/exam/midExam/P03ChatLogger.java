package MidExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03ChatLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<String> chatList = new ArrayList<>();

        while (!command.equals("end")) {
            String[] commandArr = command.split("\\s+");
            if (command.contains("Chat")) {
                chatList.add(commandArr[1]);
            } else if (command.contains("Delete")) {
                chatList.remove(commandArr[1]);
            } else if (command.contains("Edit")) {
                if (chatList.contains(commandArr[1])) {
                    int elementIndex = chatList.indexOf(commandArr[1]);
                    chatList.set(elementIndex, commandArr[2]);
                }
            } else if (command.contains("Pin")) {
                if (chatList.contains(commandArr[1])) {
                    chatList.remove(commandArr[1]);
                    chatList.add(commandArr[1]);
                }
            } else if (command.contains("Spam")) {
                for (int i = 1; i < commandArr.length; i++) {
                    chatList.add(commandArr[i]);
                }
            }
            command = scanner.nextLine();
        }
        for (String s : chatList) {
            System.out.println(s);
        }
    }
}
