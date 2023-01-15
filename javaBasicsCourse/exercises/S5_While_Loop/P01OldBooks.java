package S5_While_Loop;

import java.util.Scanner;

public class P01OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bookWanted = scanner.nextLine();

        int counterBooks = 0;
        boolean bookFound = false;

        String bookInput = scanner.nextLine();
        while (!bookInput.equals("No More Books")) {
            if (bookWanted.equals(bookInput)){
                bookFound = true;
                break;
            }
            bookInput = scanner.nextLine();
            counterBooks++;
        }

        if (bookFound){
            System.out.printf("You checked %d books and found it.", counterBooks);
        }  else {
            System.out.printf("The book you search is not here!%n");
            System.out.printf("You checked %d books.%n", counterBooks);
        }
    }
}
