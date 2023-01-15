package S2_Conditional_Statements_MORE_Exercises;

import java.util.Scanner;

public class P01PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int poolVolume = Integer.parseInt(scanner.nextLine());
        int pipeOneDebitPerHour = Integer.parseInt(scanner.nextLine());
        int pipeTwoDebitPerHour = Integer.parseInt(scanner.nextLine());
        double hours = Double.parseDouble(scanner.nextLine());

        double pipeOneDebit = pipeOneDebitPerHour * hours;
        double pipeTwoDebit = pipeTwoDebitPerHour * hours;
        double totalPipesDebit = pipeOneDebit + pipeTwoDebit;

        if (totalPipesDebit <= poolVolume){
            double totalPercentage = totalPipesDebit / poolVolume * 100;
            double pipeOnePercentage = pipeOneDebit / totalPipesDebit * 100;
            double pipeTwoPercentage = pipeTwoDebit / totalPipesDebit * 100;
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%." ,totalPercentage, pipeOnePercentage, pipeTwoPercentage);
        } else {
            double overflow = totalPipesDebit - poolVolume;
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", hours, overflow);
        }
    }
}
