import entities.Town;
import entities.Utils;

import javax.persistence.EntityManager;


public class P02ChangeCasing {
    public static void main(String[] args) {

        final EntityManager entityManager = Utils.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createQuery("SELECT t FROM Town t " +
                "where length(t.name) <= 5", Town.class)
                .getResultList()
                .forEach(town -> town.setName(town.getName().toUpperCase()));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
