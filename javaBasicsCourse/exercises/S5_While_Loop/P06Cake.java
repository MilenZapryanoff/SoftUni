package S5_While_Loop;

import java.util.Scanner;

public class P06Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());

        int totalPiecesCake = width * length;
        int totalPiecesTaken = 0;
        int result = 0;

        String input = scanner.nextLine();

        while (!input.equals("STOP")){
            int currentNum = Integer.parseInt(input);
            totalPiecesTaken = totalPiecesTaken + currentNum;
            result = totalPiecesCake - totalPiecesTaken;
            if (result <= 0 ){
                break;
            }
            input = scanner.nextLine();
        }
         if (result > 0){
            System.out.printf("%d pieces are left.", result);
        } else {
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(result));
        }
    }
}
