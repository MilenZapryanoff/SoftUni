package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int BROKEN_AXE_DURABILITY = 0;
    private static final int AXE_DURABILITY_DECREASE_AFTER_ATTACK = 1;
    private static final int DUMMY_HEALTH = 100;
    private static final int DUMMY_EXPERIENCE = 20;

    private Axe axe;
    private Axe brokenAxe;
    private Dummy dummy;

    @Before
    public void setup() {
        axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        brokenAxe = new Axe(AXE_ATTACK, BROKEN_AXE_DURABILITY);
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void TestWeaponLosesDurabilityAfterAttack() {
        axe.attack(dummy);
        Assert.assertEquals(AXE_DURABILITY - AXE_DURABILITY_DECREASE_AFTER_ATTACK, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void TestAttackWithBrokenAxeThrowsException() {
        brokenAxe.attack(dummy);
    }
}