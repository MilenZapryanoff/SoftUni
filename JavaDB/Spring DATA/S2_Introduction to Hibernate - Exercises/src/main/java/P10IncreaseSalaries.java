import entities.Employee;
import entities.Utils;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class P10IncreaseSalaries {
    public static void main(String[] args) {
        final EntityManager entityManager = Utils.createEntityManager();

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e " +
                "where e.department.name in ('Engineering', 'Tool Design', 'Marketing', 'Information Services')", Employee.class)
                .getResultList();

        employees.forEach(e -> {
            double newSalary = Double.parseDouble(String.valueOf(e.getSalary())) * 1.12;

            entityManager.getTransaction().begin();
            e.setSalary(BigDecimal.valueOf(newSalary));
            entityManager.getTransaction().commit();

            System.out.printf("%s %s ($%.2f)%n",
                    e.getFirstName(),
                    e.getLastName(),
                    e.getSalary());
        });

    }
}
