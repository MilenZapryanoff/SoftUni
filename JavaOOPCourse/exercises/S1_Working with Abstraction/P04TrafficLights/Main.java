package S1_Working_with_Abstraction.P04TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String signals[] = scanner.nextLine().split("\\s+");
        int iterations = Integer.parseInt(scanner.nextLine());

        //съзадаваме си лист за да съхраняваме светофарите
        List<TrafficLight> trafficLights = new ArrayList<>();
        for (String signal : signals) {
            Color color = Color.valueOf(signal);
            //създаваме си светофар със съответния цвят
            TrafficLight trafficLight = new TrafficLight(color);
            //добавяме светофара към листа
            trafficLights.add(trafficLight);
        }

        //итерираме по листа със светофари за да сменим цвета и да отпечатаме
        for (int i = 0; i < iterations; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                //сменяме цвета чрез мотода за смяна на свят
            trafficLight.changeColor();
                System.out.print(trafficLight.getColor() + " ");
            }
            System.out.println();
        }

    }
}
