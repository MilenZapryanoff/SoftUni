package S4_For_Loop;

import java.util.Scanner;

public class P05Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tabs = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());

        int penalty = 0;

        for (int i = 1; i <= tabs; i++) {
            String website = scanner.nextLine();
        if (website.equals("Facebook")){
            penalty = penalty + 150;
            if (salary<=penalty){
                tabs = i;
            }
        } else if (website.equals("Instagram")) {
            penalty = penalty + 100;
            if (salary<=penalty){
                tabs = i;
            }
        } else if (website.equals("Reddit")) {
            penalty = penalty + 50;
            if (salary<=penalty){
                tabs = i;
            }
        } //if (salary<=penalty) {
          //  break;
          //  }
                }
        if (salary<=penalty){
            System.out.println("You have lost your salary.");
        } else {
            System.out.printf("%d",salary-penalty);
        }

    }
}
