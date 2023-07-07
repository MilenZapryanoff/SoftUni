import entities.Employee;
import entities.Utils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class P04EmployeesWithSalaryOver50000 {

    private final static BigDecimal MIN_SALARY = BigDecimal.valueOf(50000);

    public static void main(String[] args) {
        final EntityManager entityManager = Utils.createEntityManager();

        entityManager.createQuery("SELECT e FROM Employee e " +
                        "where e.salary > :salary", Employee.class)
                .setParameter("salary", MIN_SALARY)
                .getResultList()
                .forEach(employee -> System.out.println(employee.getFirstName()));

        entityManager.close();
    }
}
