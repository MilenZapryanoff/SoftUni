package While_Loop_Lab;

import java.util.Scanner;

public class P08Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        boolean isExcluded = false;
        int year = 1;
        double allGrades = 0;
        int poorGradeCounter = 0;

        while (year <= 12){
            if (poorGradeCounter > 1) {
                isExcluded = true;
                break;
            }
            double grade = Double.parseDouble(scanner.nextLine());
            if (grade < 4){
                poorGradeCounter++;
                continue;
            }
            allGrades = allGrades + grade;
            year++;
       }

        if (isExcluded==true) {
            System.out.printf("%s has been excluded at %d grade%n", name, year);
        } else {
            double avgGrade = allGrades / 12;
            System.out.printf("%s graduated. Average grade: %.2f",name ,avgGrade );
        }
    }
}
