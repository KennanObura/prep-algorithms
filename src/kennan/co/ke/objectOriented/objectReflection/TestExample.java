package kennan.co.ke.objectOriented.objectReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestExample {
    public static void main(String[] args) throws Exception {
        Example example = new Example(2);

        Class<?> exampleClass = example.getClass();

        System.out.println("Object name is " + exampleClass);

        Constructor<?> constructors = exampleClass.getConstructor();


//        System.out.println(constructors.length);
//        for (Constructor<?> c : constructors)
        System.out.println("Constructor name is " + constructors.getName());

        Method[] methods = exampleClass.getMethods();
        for(Method method : methods)
            System.out.println("Methods are " + method.getName());

        Method method1 = exampleClass.getDeclaredMethod("setNum", int.class);

        method1.setAccessible(true);
        method1.invoke(example, 28);

    }
}
