package S5_Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> trainList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] inputArr;
            if (input.contains("Add")) {
                inputArr = input.split(" ");
                trainList.add(Integer.valueOf(inputArr[1]));
            } else {
                int currentNum = Integer.parseInt(input);
                for (int i = 0; i < trainList.size(); i++) {
                    if (trainList.get(i) + currentNum <= maxCapacity) {
                        trainList.set(i, trainList.get(i) + currentNum);
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.println(trainList.toString().replaceAll("[\\[\\],]", ""));
    }
}
