package Nested_Loops_Lab;

public class P01Clock {
    public static void main(String[] args) {

        for (int hour = 0; hour < 24; hour++) {
            for (int min = 0; min < 60; min++) {
                System.out.printf("%d:%d%n", hour, min);
            }
        }
    }
}
