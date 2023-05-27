package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private static final String[] STRING_ELEMENTS = {"A", "B", "C", "D"};
    private ListIterator listIterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(STRING_ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestConstructorWithNullArgument() throws OperationNotSupportedException {
        listIterator = new ListIterator(null);
    }

    @Test
    public void TestHasNext() {
        for (int i = 0; i < STRING_ELEMENTS.length; i++) {
            if (i < (STRING_ELEMENTS.length - 1)) {
                Assert.assertTrue(listIterator.hasNext());
                Assert.assertTrue(listIterator.move());
            } else {
                Assert.assertFalse(listIterator.hasNext());
                Assert.assertFalse(listIterator.move());
            }
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintWhenEmptyList() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintList() throws OperationNotSupportedException {
        int index = 0;
        while (listIterator.hasNext()) {
            Assert.assertEquals(listIterator.print(), STRING_ELEMENTS[index]);
            index++;
            listIterator.move();
        }
    }
}