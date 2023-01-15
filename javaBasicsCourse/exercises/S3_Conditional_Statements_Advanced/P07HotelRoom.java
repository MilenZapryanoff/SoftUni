package S3_Conditional_Statements_Advanced;

import java.util.Scanner;

public class P07HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int stay = Integer.parseInt(scanner.nextLine());

        double apartmentPrice = 0.0;
        double studioPrice = 0.0;

        if (month.equals("May") || month.equals("October")){
            if (stay > 7 && stay <=14){
            apartmentPrice = 65;
            studioPrice = 50 - (50 * 0.05);
            } else if (stay > 14) {
            apartmentPrice = 65 - (65 * 0.10);
            studioPrice =  50 - (50 * 0.30);
            } else {
            apartmentPrice = 65;
            studioPrice = 50;
            }
        } else if (month.equals("June") || month.equals("September")) {
            if (stay > 14) {
                apartmentPrice = 68.70 - (68.70 * 0.10);
                studioPrice = 75.20 - (75.20 * 0.20);
            } else {
                apartmentPrice = 68.70;
                studioPrice = 75.20;
            }
        } else if (month.equals("July") || month.equals("August")) {
            if (stay > 14) {
                apartmentPrice = 77 - (77 * 0.10);
                studioPrice =  76;
            } else {
                apartmentPrice = 77;
                studioPrice = 76;
            }
        }
        double spendingsApartment = apartmentPrice * stay;
        double spendingsStudio = studioPrice * stay;

        System.out.printf("Apartment: %.2f lv. %n", spendingsApartment);
        System.out.printf("Studio: %.2f lv.", spendingsStudio);

    }
}
