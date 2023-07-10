import entities.Project;
import entities.Utils;

import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.List;

public class P09FindTheLatest10Projects {
    public static void main(String[] args) {
        final EntityManager entityManager = Utils.createEntityManager();

        List<Project> projects = entityManager.createQuery("SELECT p FROM Project p " +
                        "where p.endDate = null " +
                        "Order by p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList();

        projects.stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> {
                    System.out.printf("Project name: %s%n", p.getName());
                    System.out.printf("Project Description: %s%n", p.getDescription());
                    System.out.printf("Project Start Date: %s%n", p.getStartDate());
                    System.out.printf("Project End Date: %s%n", p.getEndDate());
                });
    }
}
