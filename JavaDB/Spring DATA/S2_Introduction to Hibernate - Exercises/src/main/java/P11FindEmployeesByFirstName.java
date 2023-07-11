import entities.Employee;
import entities.Utils;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class P11FindEmployeesByFirstName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final EntityManager entityManager = Utils.createEntityManager();

        System.out.print("Enter pattern: ");
        String pattern = scanner.nextLine() + "%";

        List<Employee> employeeList = entityManager.createQuery("SELECT e FROM Employee e " +
                "where e.firstName like :criteria " +
                "Order by e.id", Employee.class)
                .setParameter("criteria", pattern)
                .getResultList();

        employeeList.forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n",
                e.getFirstName(),
                e.getLastName(),
                e.getJobTitle(),
                e.getSalary()));

    }
}
