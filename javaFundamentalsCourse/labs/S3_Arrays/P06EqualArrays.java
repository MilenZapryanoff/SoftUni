package S3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P06EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        int sum = 0;
        int diffIndex = 0;
        boolean difference = false;

        for (int i = 0; i < firstArr.length; i++) {
            if (firstArr[i] == secondArr[i]){
              sum += firstArr[i];
            } else {
                diffIndex =  i;
                difference = true;
                break;
            }
        }
        if (difference){
            System.out.printf("Arrays are not identical. Found difference at %d index.", diffIndex);
        } else {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
