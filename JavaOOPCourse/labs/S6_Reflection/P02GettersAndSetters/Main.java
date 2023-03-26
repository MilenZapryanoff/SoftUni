package S6_Reflection.P02GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class reflection = Reflection.class;

        Method[] declaredMethods = reflection.getDeclaredMethods();

        Arrays.stream(declaredMethods)
                .filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s will return %s%n", method.getName(), method.getReturnType()));

        Arrays.stream(declaredMethods)
                .filter(method -> method.getName().startsWith("set") && method.getParameterCount() == 1)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s will return %s%n", method.getName(), method.getReturnType()));
    }
}
