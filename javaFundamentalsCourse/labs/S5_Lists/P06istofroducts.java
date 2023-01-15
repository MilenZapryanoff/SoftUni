package S5_Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P06istofroducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> prodList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            prodList.add(scanner.nextLine());
        }
        Collections.sort(prodList);

        for (int i = 0; i < n; i++) {
            System.out.println(i+1 + "." + prodList.get(i));
        }
    }
}
