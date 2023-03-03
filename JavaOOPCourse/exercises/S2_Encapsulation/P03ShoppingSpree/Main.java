package S2_Encapsulation.P03ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] personInput = scanner.nextLine().split("\\;");
        List<Person> personList = new ArrayList<>();
        for (String currentPerson : personInput) {
            String[] people = currentPerson.split("=");
            String name = people[0];
            double money = Double.parseDouble(people[1]);
            Person person = new Person(name, money);
            personList.add(person);
        }

        String[] productInput = scanner.nextLine().split("\\;");
        List<Product> productList = new ArrayList<>();
        for (String currentProduct : productInput) {
            String[] prod = currentProduct.split("=");
            String name = prod[0];
            double cost = Double.parseDouble(prod[1]);
            Product product = new Product(name, cost);
            productList.add(product);
        }

        String command = scanner.nextLine();
        while (!command.equals("END")) {

            String[] input = command.split("\\s+");
            String name = input[0];
            String product = input[1];

            Person currentPerson = null;
            for (Person person : personList) {
                if (person.getName().equals(name)) {
                    currentPerson = person;
                }
            }

            Product currentProduct = null;
            for (Product product1 : productList) {
                if (product1.getName().equals(product)) {
                    currentProduct = product1;
                }
            }

            currentPerson.buyProduct(currentProduct);
            command = scanner.nextLine();
        }


        for (Person person : personList) {
            List<Product> personProducts = person.getProducts();
            if (personProducts.size() == 0) {
                System.out.println(person.getName() + " - Nothing bought");
            } else {
                System.out.print(person.getName() + " - ");
                for (int i = 0; i < personProducts.size(); i++) {
                    System.out.print(personProducts.get(i).getName());
                    if (i < personProducts.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }
    }
}