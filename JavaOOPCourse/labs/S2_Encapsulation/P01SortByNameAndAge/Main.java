package S2_Encapsulation.P01SortByNameAndAge;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);

            Person personToAdd = new Person(firstName, lastName,age);
            people.add(personToAdd);
        }
        //сортиране на лист първо по име, след това по години
        people.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getAge));

        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}
