package S2_Data_Types_and_Variables;

import java.util.Scanner;

public class P08LowerorUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char input = scanner.nextLine().charAt(0);

        if (Character.isUpperCase(input)){
            System.out.println("upper-case");
        } else {
            System.out.println("lower-case");
        }
    }
}
