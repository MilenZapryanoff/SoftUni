package EXAM;

import java.util.Scanner;

public class P04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());

        double sumOfAllGrades = 0;
        double counterGradeA = 0;
        double counterGradeB = 0;
        double counterGradeC = 0;
        double counterGradeD = 0;

        for (int i = 1; i <= students ; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            sumOfAllGrades = sumOfAllGrades + grade;
            if (grade >= 5){
                counterGradeA++;
            } else if (grade >= 4) {
                counterGradeB++;
            } else if (grade >= 3) {
                counterGradeC++;
            } else if (grade < 3) {
                counterGradeD++;
            }
        }

        double gradeAPercentage = counterGradeA / students * 100;
        double gradeBPercentage = counterGradeB / students * 100;
        double gradeCPercentage = counterGradeC / students * 100;
        double gradeDPercentage = counterGradeD / students * 100;

        double avgGrade = sumOfAllGrades / students;

        System.out.printf("Top students: %.2f%%%n", gradeAPercentage);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", gradeBPercentage);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", gradeCPercentage);
        System.out.printf("Fail: %.2f%%%n", gradeDPercentage);
        System.out.printf("Average: %.2f%n", avgGrade);

    }
}
