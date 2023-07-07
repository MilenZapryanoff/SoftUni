package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Utils {

    public static EntityManager createEntityManager() {
        final EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        final EntityManager entityManager = factory.createEntityManager();
        return entityManager;
    }
}
