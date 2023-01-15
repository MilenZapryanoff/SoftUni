package S5_Lists;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SumAdjacentEqualNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Double> inputList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        for (int i = 0; i < inputList.size() - 1; i++) {
            double currentNum = inputList.get(i);
            double secondNum = inputList.get(i + 1);
            if (currentNum == secondNum) {
                inputList.set(i, currentNum + secondNum);
                inputList.remove(i + 1);
                i = -1;
            }
        }

        DecimalFormat df = new DecimalFormat("0.##");
        for (double element: inputList) {
            System.out.print(df.format(element) + " ");
        }
    }
}
