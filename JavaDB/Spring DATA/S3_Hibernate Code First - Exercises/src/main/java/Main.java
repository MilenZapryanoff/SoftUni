import Entity.hospital.Diagnose;
import Entity.hospital.Medicament;
import Entity.hospital.Patient;
import Entity.hospital.Visitation;
import Entity.sales.Customer;
import Entity.sales.Product;
import Entity.sales.Sale;
import Entity.sales.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String unitName = "";

        System.out.print("Enter task number (from 1 to 5): ");
        int task = Integer.parseInt(scanner.nextLine());

        switch (task) {
            case 1 -> unitName = "gringotts";
            case 2 -> unitName = "sales";
            case 3 -> unitName = "university";
            case 4 -> unitName = "hospital";
            case 5 -> unitName = "bank";
        }

        EntityManager entityManager = createEntityManager(unitName);
        entityManager.getTransaction().begin();


        /* Task2 test
        Customer customer = new Customer("Test It again", "test@tester.com", "5366 6499 1359 9568");
           entityManager.persist(customer);

        Product product = new Product("Best Product ever", 2, BigDecimal.TEN);
            entityManager.persist(product);

        StoreLocation storeLocation = new StoreLocation("Vitoshka 11");
        entityManager.persist(storeLocation);

        Sale sale = new Sale();
        sale.setDateTime(LocalDateTime.now());
        sale.setProduct(product);
        sale.setCustomer(customer);
        sale.setStoreLocation(storeLocation);
        entityManager.persist(sale);
        */

        /* Task 4 test
        Patient patient = new Patient("Болен", "Пациент", "София","losho@mi_e.bg", LocalDate.parse("1999-01-01"), true);

        Visitation visitation = new Visitation();
        visitation.setVisitationDate(LocalDateTime.now());
        visitation.setComment("7 дни почивка и пациента е готов");
        visitation.setPatient(patient);

        Diagnose diagnose = new Diagnose();
        diagnose.setName("Настинка");

        Medicament medicament = new Medicament();
        medicament.setName("Coldrex");

        patient.getDiagnoses().add(diagnose);
        patient.getMedicaments().add(medicament);
        patient.getVisitations().add(visitation);
        entityManager.persist(patient);

         */

        entityManager.getTransaction().commit();
    }

    private static EntityManager createEntityManager(String unitName) {
        return Persistence.createEntityManagerFactory(unitName).createEntityManager();
    }
}
