package S3_Sets_and_Maps_Advanced;

import java.math.BigDecimal;
import java.util.*;

public class P08AcademyGraduation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int cycles = Integer.parseInt(scanner.nextLine());
        TreeMap<String, Double> gradesMap = new TreeMap<>();

        for (int i = 0; i < cycles; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            //изчисляване на средната оценка
            double allGrades = 0;
            for (int j = 0; j < grades.length; j++) {
                double currentGrade = grades[j];
                allGrades += currentGrade;
            }
            double avgGrade = allGrades / grades.length;
            //попълване на map-а
            if (!gradesMap.containsKey(name)) {
                gradesMap.put(name, avgGrade);
            }
        }
        //печат на entryset-а от map-a
        for (Map.Entry<String, Double> entry : gradesMap.entrySet()) {
            String result = String.valueOf(entry.getValue());
            System.out.printf("%s is graduated with %s%n", entry.getKey(), result);
        }
    }
}
