package S1_First_Steps_In_Coding;

import java.util.Scanner;

public class P02RadianstoDegrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double radians = Double.parseDouble(scanner.nextLine());
        Double degrees = radians * 180 / Math.PI;
        System.out.println(degrees);
    }
}
