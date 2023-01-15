package S6_Nested_Loops;

import java.util.Scanner;

public class P01NumberPyramid {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int currentNum = 0;
        boolean isValid = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                currentNum++;
                System.out.print(currentNum + " ");
                if (currentNum >= n){
                    isValid = true;
                    break;
                }
            }
            if (isValid){
                break;
            }
            System.out.println("");
        }

    }
}
