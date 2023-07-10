import entities.Employee;
import entities.Utils;

import javax.persistence.EntityManager;

public class P05EmployeesFromDepartment {
    private static final String DEPARTMENT_NAME = "Research and Development";

    public static void main(String[] args) {

        final EntityManager entityManager = Utils.createEntityManager();

        entityManager.createQuery("SELECT e FROM Employee e " +
                        "where e.department.name = :d_name " +
                        "Order by e.salary, e.id", Employee.class)
                .setParameter("d_name", DEPARTMENT_NAME)
                .getResultList()
                .forEach(employee -> System.out.printf("%s %s from %s - %.2f%n",
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getDepartment().getName(),
                        employee.getSalary()));
    }
}
