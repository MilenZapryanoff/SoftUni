package First_Steps_In_Coding_Lab;

import java.util.Scanner;

public class P07ProjectsCreation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String architect = scanner.nextLine();
        int projectCount = Integer.parseInt(scanner.nextLine());
        int totalHours = projectCount * 3;
        System.out.printf("The architect %s will need %d hours to complete %s project/s.",architect, totalHours, projectCount);
    }

}

//"The architect {името на архитекта} will need {необходими часове} hours to complete {брой на проектите} project/s."