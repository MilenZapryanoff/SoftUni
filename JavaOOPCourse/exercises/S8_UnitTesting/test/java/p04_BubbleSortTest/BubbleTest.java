package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    @Test
    public void TestBubbleSord() {
        int[] numbers = {34, 2, 0, 45, 76, 23, 46, 1, 8, 897, 39, 54};
        Bubble.sort(numbers);

        int[] expected = {0, 1, 2, 8, 23, 34, 39, 45, 46, 54, 76, 897};

        Assert.assertArrayEquals(expected, numbers);
    }
}