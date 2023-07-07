import entities.Employee;
import entities.Utils;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class P03ContainsEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final EntityManager entityManager = Utils.createEntityManager();

        System.out.print("Enter employee full name: ");
        String[] fullName = scanner.nextLine().split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];

        List<Employee> employees = entityManager.createQuery("FROM Employee " +
                        "where firstName = :firstParameter " +
                        "and lastName = :secondParameter", Employee.class)
                .setParameter("firstParameter", firstName)
                .setParameter("secondParameter", lastName)
                .getResultList();

        printResult(employees);

        entityManager.close();
    }

    private static void printResult(List<Employee> employees) {
        if (employees.size() == 0) {
            System.out.println("No");
        } else if (employees.size() > 1) {
            System.out.println("More than one record found for this search");
        } else {
            System.out.println("Yes");
        }
    }
}
