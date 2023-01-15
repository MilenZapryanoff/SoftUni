package S3_Conditional_Statements_Advanced;

import java.util.Scanner;

public class P09SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stay = Integer.parseInt(scanner.nextLine());
        String room = scanner.nextLine();
        String feedback = scanner.nextLine();

        double pricePerNight = 0.0;
        double totalPrice = 0.0;

        if (room.equals("room for one person")){
            pricePerNight = 18; totalPrice = pricePerNight * (stay -1);

        } else if (room.equals("apartment")) {
            pricePerNight = 25; totalPrice = pricePerNight * (stay -1);
            if (stay < 10){
            totalPrice = totalPrice - (totalPrice * 0.30);
            } else if (stay < 15) {
            totalPrice = totalPrice - (totalPrice * 0.35);
            } else if (stay > 15) {totalPrice = totalPrice - (totalPrice * 0.50);
            }
        } else if (room.equals("president apartment")) {
            pricePerNight = 35; totalPrice = pricePerNight * (stay -1);
            if (stay < 10){
                totalPrice = totalPrice - (totalPrice * 0.10);
            } else if (stay < 15) {
                totalPrice = totalPrice - (totalPrice * 0.15);
            } else if (stay > 15) {totalPrice = totalPrice - (totalPrice * 0.20);
            }
        }
        if (feedback.equals("positive")){
            totalPrice = totalPrice + (totalPrice * 0.25);
        } else if (feedback.equals("negative")) {
            totalPrice = totalPrice - (totalPrice * 0.10);
        }
        System.out.printf("%.2f",totalPrice);
    }
}
