package S1_Working_with_Abstraction.P02PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int bottomLeftX = coordinates[0];
        int bottomLeftY = coordinates[1];
        int topRightX = coordinates[2];
        int topRightY = coordinates[3];

        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);
        Point topRight = new Point(topRightX, topRightY);
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfInputs; i++) {
            int[] checkCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int x = checkCoordinates[0];
            int y = checkCoordinates[1];
            Point currentPoint = new Point(x, y);
            System.out.println(rectangle.contains(currentPoint));
        }
    }
}
