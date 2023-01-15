package S5_While_Loop;

import java.util.Scanner;

public class P2ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int poorGradesAllowed = Integer.parseInt(scanner.nextLine());
        String problemName = scanner.nextLine();

        int numberOfProblems = 0;
        double gradesSum = 0.0;
        int poorGrades = 0;
        String lastProblemName = "";
        boolean isExcluded = false;


        while (!problemName.equals("Enough")){
            double grade = Double.parseDouble(scanner.nextLine());
            gradesSum = gradesSum + grade;
            numberOfProblems++;
        if (grade <= 4 ) {
            poorGrades++;
        }
        if (poorGrades >= poorGradesAllowed){
            isExcluded = true;
            break;
        }
            lastProblemName = problemName;
            problemName = scanner.nextLine();
        }
        if (isExcluded){
            System.out.printf("You need a break, %d poor grades.", poorGrades);
        } else {
            System.out.printf("Average score: %.2f%n", gradesSum/numberOfProblems);
            System.out.printf("Number of problems: %d%n", numberOfProblems);
            System.out.printf("Last problem: %s", lastProblemName);
        }
    }
}
