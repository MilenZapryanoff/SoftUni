package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final Integer[] NUMBERS = {7, 45, 34, 12, 98, 23};
    private static final Integer DEFAULT_NUMBER_TO_ADD = 0;
    public Database database;

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void TestConstructorHasCreatedValidObject() {
        //Act
        Integer[] elements = database.getElements();
        // Assert
        Assert.assertArrayEquals(elements, NUMBERS);
        //Assert.assertEquals(elements.length, NUMBERS.length);
        //for (int i = 0; i < elements.length; i++) {
        //Assert.assertEquals(elements[i], NUMBERS[i]);
        //}
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestConstructorThrowMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] elements = new Integer[17];
        new Database(elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestConstructorThrowLessThanOneElement() throws OperationNotSupportedException {
        Integer[] elements = new Integer[0];
        new Database(elements);
    }

    @Test
    public void TestAddElementInFreeCell() throws OperationNotSupportedException {
        database.add(DEFAULT_NUMBER_TO_ADD);
        Integer[] elements = database.getElements();
        //проверка на размера на database масива
        Assert.assertEquals(NUMBERS.length + 1, database.getElements().length);
        //проверка на стойността на последния индекс
        Assert.assertEquals(elements[elements.length - 1], DEFAULT_NUMBER_TO_ADD);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestAddNullElement() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void TestAddElementToFullArray() throws OperationNotSupportedException {
        Integer[] elements = new Integer[16];
        for (int i = 0; i <= elements.length; i++) {
            database.add(DEFAULT_NUMBER_TO_ADD);
        }
    }

    @Test
    public void TestRemoveLastElement() throws OperationNotSupportedException {
        //Act
        database.remove();
        Integer lastIndexElement = database.getElements()[database.getElements().length - 1];
        //Assert
        Assert.assertEquals(NUMBERS.length - 1, database.getElements().length);
        Assert.assertEquals(NUMBERS[NUMBERS.length - 2], lastIndexElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestThrowExceptionWhenRemoveElementFromEmptyArray() throws OperationNotSupportedException {
        database = new Database(new Integer[1]);
        for (int i = 0; i < 2; i++) {
            database.remove();
        }
    }
}

