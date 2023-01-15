package S5_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();

        int minSize;
        boolean firstIsSmaller = false;
        if (firstList.size() < secondList.size()) {
            firstIsSmaller = true;
            minSize = firstList.size();
        } else {
            minSize = secondList.size();
        }
             for (int i = 0; i < minSize; i++) {
                int fistNum = firstList.get(i);
                int secondNum = secondList.get(i);
                resultList.add(fistNum);
                resultList.add(secondNum);
            }

        if (!firstIsSmaller) {
            resultList.addAll(firstList.subList(minSize, firstList.size()));
        } else {
            resultList.addAll(secondList.subList(minSize, secondList.size()));
        }

        System.out.println(resultList.toString().replaceAll("[\\[\\],]", ""));
    }
}