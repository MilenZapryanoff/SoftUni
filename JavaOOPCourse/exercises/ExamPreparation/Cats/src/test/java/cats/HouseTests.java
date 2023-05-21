package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HouseTests {
    private static final String DEFAULT_NAME = "myHouse";
    private static final int DEFAULT_CAPACITY = 5;
    private List<Cat> cat;

    private static House createsHouseAndAddsCats() {
        House house = new House(DEFAULT_NAME, DEFAULT_CAPACITY);
        house.addCat(new Cat("Aaron"));
        house.addCat(new Cat("Buddy"));
        return house;
    }

    @Before
    public void setUp() {
        House house = createsHouseAndAddsCats();
        cat = new ArrayList<>();
    }

    @Test
    public void testConstructor() {
        House house = new House(DEFAULT_NAME, DEFAULT_CAPACITY);
        Assert.assertEquals(DEFAULT_NAME, house.getName());
        Assert.assertEquals(DEFAULT_CAPACITY, house.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorWithEmptyName() {
        House house = new House(null, DEFAULT_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithEmptyCapacity() {
        House house = new House(DEFAULT_NAME, -1);
    }

    @Test
    public void testGetCount() {
        House house = createsHouseAndAddsCats();
        Assert.assertEquals(2, house.getCount());
      }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatWithNoCapacity() {
        House house = createsHouseAndAddsCats();
        for (int i = 0; i <= 4; i++) {
            house.addCat(new Cat("Cat"));
        }
    }

    @Test
    public void removeCat() {
        House house = createsHouseAndAddsCats();
        Assert.assertEquals(2, house.getCount());
        house.removeCat("Aaron");
        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCatIfCatInputIsNull() {
        House house = createsHouseAndAddsCats();
        house.removeCat("notExistingCat");
    }

    @Test
    public void testCatForSale() {
        House house = createsHouseAndAddsCats();
        Cat cat = house.catForSale("Aaron");

        Assert.assertFalse(cat.isHungry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleThrowsException() {
        House house = createsHouseAndAddsCats();
        Cat cat = house.catForSale("notExistingCat");
    }

    @Test
    public void testStatistics() {
        House house = createsHouseAndAddsCats();
        Assert.assertEquals("The cat Aaron, Buddy is in the house myHouse!", house.statistics());
    }
}
