import entities.Address;
import entities.Employee;
import entities.Utils;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class P06AddingNewAddressAndUpdatingTheEmployee {

    private static final String NEW_ADDRESS = "Vitoshka 15";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final EntityManager entityManager = Utils.createEntityManager();

        System.out.print("Enter employee's last name to update address: ");
        String lastName = scanner.nextLine();

        // За да избегна създаване на еднакви адреси при всяко run-ване на програмата добавям проверка за наличие на адреса в базата
        // стъпка 1 -> проверявам за наличие на адреса
        // стъпка 2 -> ако го няма го създавам, ако го има връщам съществуващия
        Address address = checkAddress(entityManager, NEW_ADDRESS);

        updateEmployeeAddress(entityManager, lastName, address);
    }

    private static Address checkAddress(EntityManager entityManager, String addressText) {
        List<Address> address = entityManager.createQuery("SELECT a FROM Address a " +
                        "WHERE a.text =: address_text", Address.class)
                .setParameter("address_text", addressText)
                .getResultList();
        if (address.isEmpty()) {
            //ако не е наличен адреса го създавам чрез метод createAddress
            return createAddress(entityManager, NEW_ADDRESS);
        } else {
            //ако е наличен адреса връщам първия намерен адрес с текст "Vitoshka 15"
            return address.get(0);
        }
    }

    private static Address createAddress(EntityManager entityManager, String addressText) {
        Address address = new Address();
        address.setText(addressText);
        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        return address;
    }

    private static void updateEmployeeAddress(EntityManager entityManager, String lastName, Address address) {
        List<Employee> employees = entityManager.createQuery("SELECT e from Employee e " +
                        "where e.lastName =: l_name", Employee.class)
                .setParameter("l_name", lastName)
                .getResultList();

        for (Employee employee : employees) {
            entityManager.getTransaction().begin();
            employee.setAddress(address);
            entityManager.getTransaction().commit();
        }
    }
}
