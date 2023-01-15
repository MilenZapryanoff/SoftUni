package S6_Nested_Loops;

import java.util.Scanner;

public class P04TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int jury = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        double totalGrade = 0;
        int totalCounter = 0;

        while (!input.equals("Finish")) {
            String presentation = input;

            double grade = 0;
            for (int i = 1; i <= jury ; i++) {
            double currentGrade = Double.parseDouble(scanner.nextLine());
            grade = grade + currentGrade;
            totalGrade = totalGrade + currentGrade;
            totalCounter++;
            }

            System.out.printf("%s - %.2f.%n", presentation, grade / jury);

            input = scanner.nextLine();
        }
        double assessment = totalGrade / totalCounter;
        System.out.printf("Student's final assessment is %.2f.", assessment);
    }
}
