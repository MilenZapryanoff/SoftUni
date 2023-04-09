package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {

    @Test
    public void TestAlarmWithLowValue() {
        //Arrange
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(15.3);
        //Act
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        //Assert
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void TestAlarmWithHighValue() {
        //Arrange
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22.5);
        //Act
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        //Assert
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void TestAlarmWithNormalValue() {
        //Arrange
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(20.1);
        //Act
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        //Assert
        Assert.assertFalse(alarm.getAlarmOn());
    }
}