import entities.Employee;
import entities.Project;
import entities.Utils;
import javax.persistence.EntityManager;
import java.util.Scanner;

public class P08GetEmployeesWithProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final EntityManager entityManager = Utils.createEntityManager();

        System.out.print("Please enter employee ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        Employee employee = entityManager.createQuery("SELECT e FROM Employee e " +
                        "where e.id =: employee_id", Employee.class)
                .setParameter("employee_id", id)
                .getSingleResult();

        PrintResult(employee);
    }

    private static void PrintResult(Employee employee) {
        System.out.printf("%s %s - %s%n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle());

        employee.getProjects().stream()
                .map(Project::getName)
                .sorted()
                .forEach(System.out::println);
    }
}
