package S6_Defining_classes.P01OpinionPoll;

import java.util.*;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> peopleList = new TreeSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {

            String[] currentLine = scanner.nextLine().split("\\s+");
            String name = currentLine[0];
            int age = Integer.parseInt(currentLine[1]);

            if (age > 30) {
                Person person = new Person(name, age);
                peopleList.add(String.valueOf(person));
            }
        }
        for (String s : peopleList) {
            System.out.println(s);
        }
    }
}
