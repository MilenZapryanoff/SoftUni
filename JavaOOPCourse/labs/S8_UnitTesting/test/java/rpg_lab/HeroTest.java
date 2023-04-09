package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.nio.channels.AcceptPendingException;

import static org.junit.Assert.*;

public class HeroTest {

    // private static final int DUMMY_XP = 10;
    // private static final int DUMMY_HEALTH = 1;
    private static  final  int TARGET_XP = 10;

    @Test
    public void TestHeroGainsXPWhenTargetDies() {
        //Arrange
        //Dummy dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);

        //за да можем да не разчитаме на другите класове а да дефинираме собствени отговори на методите,
        //които викаме от методите използваме Mochito за да подадем желани от нас стойнисто като отговор.
        Dummy dummy = Mockito.mock(Dummy.class);
        Mockito.when(dummy.isDead()).thenReturn(true);
        Mockito.when(dummy.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero("MyHero");
        //Act
        hero.attack(dummy);
        //Assert
        Assert.assertEquals(10, hero.getExperience());
    }

}