import entities.Utils;
import javax.persistence.EntityManager;
import java.util.List;

public class P12EmployeesMaximumSalaries {
    public static void main(String[] args) {
        final EntityManager entityManager = Utils.createEntityManager();

        List<Object[]> rows = entityManager.createQuery("SELECT e.department.name, MAX(e.salary) " +
                        "FROM Employee e " +
                        "GROUP BY e.department.name " +
                        "HAVING MAX(e.salary) NOT BETWEEN 30000 and 70000")
                .getResultList();

        rows.forEach(e -> System.out.println(e[0] + " " + e[1]));
    }
}
