package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final Person FIRST_TEST_PERSON = new Person(1, "Boris");
    private static final Person SECOND_TEST_PERSON = new Person(2, "Petar");
    private static final Person THIRD_TEST_PERSON = new Person(3, "Miroslav");

    //    private static final Person[] PEOPLE = {new Person(1, "Boris"), new Person(2, "Petar"), new Person(3, "Miroslav ")};
    private Database database;
    private Person[] testPersons;

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        testPersons = new Person[]{FIRST_TEST_PERSON, SECOND_TEST_PERSON, THIRD_TEST_PERSON};
        database = new Database(testPersons);
    }

    @Test
    public void TestConstructorHasCreatedValidObject() {
        //Act
        Person[] people = database.getElements();
        // Assert
        Assert.assertArrayEquals(people, testPersons);
        //Assert.assertEquals(elements.length, PEOPLE.length);
        //for (int i = 0; i < elements.length; i++) {
        //Assert.assertEquals(elements[i], PEOPLE[i]);
        //}
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestConstructorThrowMoreThanSixteenElements() throws OperationNotSupportedException {
        Person[] people = new Person[17];
        new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestConstructorThrowLessThanOneElement() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        new Database(people);
    }

    @Test
    public void TestAddPersonToDatabase() throws OperationNotSupportedException {
        database.add(new Person(4, "Ivan"));
        Person[] people = database.getElements();
        Assert.assertEquals(people.length, testPersons.length + 1);
        Assert.assertEquals(Integer.valueOf(people[people.length - 1].getId()), Integer.valueOf(4));
        Assert.assertEquals(people[people.length - 1].getUsername(), "Ivan");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestThrowExceptionWhenAddPersonWithNullParameter() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void TestRemovePersonFromDatabase() throws OperationNotSupportedException {
        //Act
        database.remove();
        String lastUsername = database.getElements()[database.getElements().length - 1].getUsername();
        //Assert
        Assert.assertEquals(testPersons.length - 1, database.getElements().length);
        Assert.assertEquals(testPersons[testPersons.length - 2].getUsername(), lastUsername);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestThrowExceptionWhenRemovePersonFromEmptyDatabase() throws OperationNotSupportedException {
        database = new Database(new Person(1, "test"));
        for (int i = 0; i < 2; i++) {
            database.remove();
        }
    }

    @Test
    public void TestFindByUsername() throws OperationNotSupportedException {
        Person person = database.findByUsername("Petar");
        Assert.assertEquals(2, person.getId());
        Assert.assertEquals("Petar", person.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestFindByUsernameWhenMoreThanOneUserFound() throws OperationNotSupportedException {
        database.add(new Person(4, "Boris"));
        database.findByUsername("Boris");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestFindByUsernameWhenNoUserPresent() throws OperationNotSupportedException {
        database.findByUsername("Ivan");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestThrowExceptionWhenUsernameIsNullParameter() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void TestFindById() throws OperationNotSupportedException {
        Person person = database.findById(1);
        Assert.assertEquals(1, person.getId());
        Assert.assertEquals("Boris", person.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestFindByIdWhenMoreThanOneUsersFound() throws OperationNotSupportedException {
        database.add(new Person(1, "Georgi"));
        database.findById(1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestFindByIdWhenNoUserPresent() throws OperationNotSupportedException {
        database.findById(4);
    }
}

