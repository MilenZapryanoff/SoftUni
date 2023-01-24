package S3_Sets_and_Maps_Advanced;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cycles = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> map = new TreeMap<>();

        //пълнене на Map-а
        for (int i = 0; i < cycles; i++) {

            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            String grade = input[1];

            if (!map.containsKey(name)) {
                map.put(name, new ArrayList<>()); //добавяме лист при липса на такъв Key
            }
            map.get(name).add(grade); // добаваме оценка към листа

        }
        //обхождане на Map-a
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.printf("%s -> ", entry.getKey());

            //принтиране на списъка с оценки
            String currentString = String.valueOf(entry.getValue()).replaceAll("[\\[\\],]", "");
            double[] currentStringArr = Arrays.stream(currentString.split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            for (double grade : currentStringArr) {
                System.out.printf("%.2f ", grade);
            }

            //изчисляване и принтиране на средната оценка
            String[] stringToRead = currentString.split("\\s+");
            double avgGrade = 0;
            for (String grade : stringToRead) {
                avgGrade = (avgGrade + Double.parseDouble(grade) / stringToRead.length);
            }
            System.out.printf("(avg: %.2f)%n", avgGrade);
        }
    }
}
