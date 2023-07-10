import entities.Address;
import entities.Utils;

import javax.persistence.EntityManager;
import java.util.List;

public class P07AddressesWithEmployeeCount {
    public static void main(String[] args) {
        final EntityManager entityManager = Utils.createEntityManager();

        List<Address> addressList = entityManager.createQuery("SELECT a from Address a " +
                        "Order by a.employees.size DESC ", Address.class)
                .setMaxResults(10)
                .getResultList();

        for (Address address : addressList) {
            System.out.printf("%s, %s - %d employees%n",
                    address.getText(),
                    address.getTown() == null
                            ? "Unknown" : address.getTown().getName(),
                    address.getEmployees().size());
        }
            }
}
