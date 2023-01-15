package S1_BasicSyntax_ConditionalStatements_Loops;

import java.util.Scanner;

public class P08Divisibleby3 {
    public static void main(String[] args) {

        for (int i = 3; i <= 100 ; i++) {
            if (i % 3 == 0){
                System.out.println(i);
            }
        }
    }
}
