package S7_Associative_Arrays_Maps_Lambda_and_Stream_API;

import java.util.*;

public class P05Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        LinkedHashMap<String, List<String>> coursesMap = new LinkedHashMap<>();

        while (!command.equals("end")) {
            String[] commandArr = command.split(" : ");
            String course = commandArr[0];
            String name = commandArr[1];

            if (!coursesMap.containsKey(course)) {
                coursesMap.put(course, new ArrayList<>());
            }
            coursesMap.get(course).add(name);

            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : coursesMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size());
            entry.getValue().forEach(studentName -> System.out.println("-- " + studentName));
        }
    }
}

