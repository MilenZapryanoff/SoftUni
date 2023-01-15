package S5_Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int listSize = inputList.size();
        for (int i = 0; i < listSize / 2; i++) {
            int firstNum = inputList.get(i);
            int secondNum = inputList.get(inputList.size() -1 );

            inputList.set(i, firstNum + secondNum);
            inputList.remove(inputList.size() -1);

        }
        System.out.println(inputList.toString().replaceAll("[\\[\\],]", ""));
    }
}
