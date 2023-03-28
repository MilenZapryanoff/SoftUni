package S6_Reflection.P02BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, InvocationTargetException {
        Class<BlackBoxInt> clazz = BlackBoxInt.class; // got the class
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor(); //got the constructor
        constructor.setAccessible(true); //made the constructor accessible
        BlackBoxInt blackBoxInt = constructor.newInstance(); //used constructor to create blackbox

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        Field innerValue = clazz.getDeclaredField("innerValue"); //got the innerValue field
        innerValue.setAccessible(true); //made it accessible

        while (!"END".equals(command)) {
            String[] commandParts = command.split("_");
            String methodName = commandParts[0];
            int argument = Integer.parseInt(commandParts[1]);

            Method method = clazz.getDeclaredMethod(methodName, int.class); //get the needed method
            method.setAccessible(true); //made it accessible
            method.invoke(blackBoxInt, argument); //call the method on blackbox

            System.out.println(innerValue.get(blackBoxInt));
            command = scanner.nextLine();
        }
    }
}