package robots;

import org.junit.Assert;
import org.junit.Test;

public class ServiceTests {

    private Service testService;

    @Test
    public void testConstructorSuccessful() {
        AddRobotsToNewService("MyTestService", 2);
        Assert.assertEquals(testService.getName(), "MyTestService");
        Assert.assertEquals(testService.getCapacity(), 2);
    }

    @Test
    public void testGetNameSuccessful() {
        AddRobotsToNewService("MyTestService", 2);
        Assert.assertEquals("MyTestService", testService.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCapacityWithNegativeNumber() {
        AddRobotsToNewService("MyTestService", -1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWithNullName() {
        AddRobotsToNewService(null, 2);
    }

    @Test
    public void testGetCountSuccessful() {
        AddRobotsToNewService("MyTestService", 2);
        Assert.assertEquals(2, testService.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdd() {
        AddRobotsToNewService("MyTestService", 2);
        testService.add(new Robot("C3"));
        Assert.assertEquals(2, testService.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowExceptionWhenRemoveOfNonExistingRobot() {
        AddRobotsToNewService("MyTestService", 2);
        testService.remove("C3");
        Assert.assertEquals(1, testService.getCount());
    }

    @Test
    public void testSuccessfulRemoveOfExistingRobot() {
        AddRobotsToNewService("MyTestService", 2);
        testService.remove("A1");
        Assert.assertEquals(1, testService.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowExceptionForSaleWhenNonExistingRobot() {
        AddRobotsToNewService("MyTestService", 2);
        Robot result = testService.forSale("C3");

    }

    @Test
    public void testForSaleWithValidArguments() {
        AddRobotsToNewService("MyTestService", 2);
        Robot result = testService.forSale("A1");
        Assert.assertFalse(result.isReadyForSale());
    }

    @Test
    public void testReport() {
        AddRobotsToNewService("MyTestService", 2);
        Assert.assertEquals("The robot A1, B2 is in the service MyTestService!", testService.report());
    }

    private void AddRobotsToNewService(String name, int capacity) {
        testService = new Service(name, capacity);
        testService.add(new Robot("A1"));
        testService.add(new Robot("B2"));
    }
}