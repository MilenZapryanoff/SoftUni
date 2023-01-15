package S5_Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07RemoveNegativesandeverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        inputList.removeIf(e -> e < 0);
        //for (int i = 0; i < inputList.size(); i++) {
        //  if (inputList.get(i) < 0) {
        //        inputList.remove(i);
        //        i = i -1;
        //    }
        //}

        if (inputList.isEmpty()){
            System.out.println("empty");
        } else {
            //for (int i = inputList.size() -1 ; i >= 0; i--) {
            //    System.out.print(inputList.get(i) + " ");
            //}
            Collections.reverse(inputList);
            System.out.println(inputList.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
