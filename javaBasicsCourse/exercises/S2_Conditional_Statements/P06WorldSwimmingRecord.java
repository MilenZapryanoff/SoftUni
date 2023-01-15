package S2_Conditional_Statements;

import java.util.Scanner;

public class P06WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double worldRecord = Double.parseDouble(scanner.nextLine());
        double metres = Double.parseDouble(scanner.nextLine());
        double secondsPerMeter = Double.parseDouble(scanner.nextLine());

        double seconds = metres * secondsPerMeter;
        double delayMeters = Math.floor (metres / 15);
        double delay = delayMeters * 12.5;
        double totalTime = seconds +  delay;

        if (totalTime < worldRecord){
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totalTime);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", Math.abs(worldRecord - totalTime));
        }

    }
}
