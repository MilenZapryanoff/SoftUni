package S7_Associative_Arrays_Maps_Lambda_and_Stream_API;

import java.util.*;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        LinkedHashMap<String, List<String>> companyMap = new LinkedHashMap<>();

        while (!command.equals("End")) {
            String[] commandArr = command.split(" -> ");
            String company = commandArr[0];
            String employeeId = commandArr[1];

            if (!companyMap.containsKey(company)) {
                companyMap.put(company, new ArrayList<>());
            }

            if (!companyMap.get(company).contains(employeeId)) {
                companyMap.get(company).add(employeeId);
            }

            command = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : companyMap.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(studentName -> System.out.println("-- " + studentName));
        }
    }
}
