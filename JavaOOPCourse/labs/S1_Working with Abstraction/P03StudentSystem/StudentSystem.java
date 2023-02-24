package S1_Working_with_Abstraction.P03StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentsMap;

    public StudentSystem() {
        this.studentsMap = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.studentsMap;
    }

    public void parseCommand(String[] args) {
        String firstArgument = args[0];
        String name = args[1];
        if (firstArgument.equals("Create")) {
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);
            if (!studentsMap.containsKey(name)) {
                Student student = new Student(name, age, grade);
                studentsMap.put(name, student);
            }
        } else if (firstArgument.equals("Show")) {
            if (studentsMap.containsKey(name)) {
                StringBuilder stringBuilder = new StringBuilder();
                Student student = studentsMap.get(name);
                stringBuilder.append(String.format("%s is %s years old.", student.getName(), student.getAge()));

                if (student.getGrade() >= 5.00) {
                    stringBuilder.append(" Excellent student.");
                } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                    stringBuilder.append(" Average student.");
                } else {
                    stringBuilder.append(" Very nice person.");
                }

                System.out.println(stringBuilder.toString());
            }
        }
    }
}
