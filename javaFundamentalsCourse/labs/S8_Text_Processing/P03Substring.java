package S8_Text_Processing;

import java.util.Scanner;

public class P03Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String toRemove = scanner.nextLine();
        String text = scanner.nextLine();

        int wordLength = toRemove.length();

        while (text.contains(toRemove)) {

            int firstIndex = text.indexOf(toRemove);
            int lastIndex = firstIndex + wordLength;
            text = text.substring(0, firstIndex) + text.substring(lastIndex);
            //     text = text.replace(toRemove,"");
        }
        System.out.println(text);
    }
}

