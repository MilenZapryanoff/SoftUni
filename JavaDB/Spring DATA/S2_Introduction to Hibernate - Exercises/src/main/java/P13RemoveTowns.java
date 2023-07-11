import entities.Address;
import entities.Employee;
import entities.Town;
import entities.Utils;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class P13RemoveTowns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final EntityManager entityManager = Utils.createEntityManager();

        System.out.print("Enter town name: ");
        String townName = scanner.nextLine();

        Town town = entityManager.createQuery("SELECT t FROM Town t WHERE t.name=:p_town", Town.class)
                .setParameter("p_town", townName)
                .getSingleResult();

        setEmployeeAddressToNull(entityManager, townName);

        entityManager.getTransaction().begin();
        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a WHERE a.town.id=:p_id", Address.class)
                .setParameter("p_id", town.getId())
                .getResultList();
        addresses.forEach(entityManager::remove);

        entityManager.remove(town);
        entityManager.getTransaction().commit();

        if (addresses.size() == 1) {
            System.out.printf("%d address in %s deleted", addresses.size(), townName);
        } else {
            System.out.printf("%d addresses in %s deleted", addresses.size(), townName);
        }
    }

    private static void setEmployeeAddressToNull(EntityManager entityManager, String townName) {

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e WHERE e.address.town.name = :town", Employee.class)
                .setParameter("town", townName)
                .getResultList();

        entityManager.getTransaction().begin();
        for (Employee employee : employees) {
            employee.setAddress(null);
            entityManager.persist(employee);
        }
        entityManager.getTransaction().commit();
    }
}