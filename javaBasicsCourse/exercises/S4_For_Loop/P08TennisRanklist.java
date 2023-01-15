package S4_For_Loop;

import java.util.Scanner;

public class P08TennisRanklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tournaments = Integer.parseInt(scanner.nextLine());
        int rangelistPoints = Integer.parseInt(scanner.nextLine());

        int wonPoints = 0;
        double wonTournaments = 0;

        for (int i = 1; i <= tournaments; i++) {
            String stage = scanner.nextLine();
            if (stage.equals("W")){
                wonPoints = wonPoints + 2000;
                wonTournaments++;
            } else if (stage.equals("F")) {
                wonPoints = wonPoints + 1200;
            } else if (stage.equals("SF")) {
                wonPoints = wonPoints + 720;
            }
        }

        int totalPoints = rangelistPoints + wonPoints;

        System.out.printf("Final points: %d%n", totalPoints);
        System.out.printf("Average points: %d%n", wonPoints / tournaments);
        double wonTournamentsPercentage = wonTournaments / tournaments * 100.0;
        System.out.printf("%.2f%%%n", wonTournamentsPercentage);
    }
}
