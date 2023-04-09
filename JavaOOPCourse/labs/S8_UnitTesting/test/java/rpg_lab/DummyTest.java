package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    private static final int DUMMY_HEALTH = 100;
    private static final int DEAD_DUMMY_HEALTH = 0;
    private static final int DUMMY_EXPERIENCE = 50;
    private static final int ATTACK_POINTS = 10;
    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void setUp() {
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        deadDummy = new Dummy(DEAD_DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void TestDummyLosesHealthAfterAttack() {
        //Act
        dummy.takeAttack(ATTACK_POINTS);
        //Assert
        Assert.assertEquals(DUMMY_HEALTH - ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void TestDeadDummyThrowsException() {
        //Act
        deadDummy.takeAttack(10);
        //Assert
    }

    @Test
    public void TestDeadDummyCanGiveXP() {
        //Arrange

        //Act
        int exp = deadDummy.giveExperience();
        //Assert
        Assert.assertEquals(DUMMY_EXPERIENCE, exp);
    }

    @Test(expected = IllegalStateException.class)
    public void TestAliveDummyCantGiveXP() {
        //Arrange

        //Act
        int exp = dummy.giveExperience();
        //Assert
    }
}