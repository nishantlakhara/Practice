package stackoverflow;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//https://stackoverflow.com/questions/61084662/creating-a-parser-of-class-name-string-value-to-a-typed-value
public class ReflectionExsample {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object instance1 = parse("java.lang.String", "abc", false);
        Object instance2 = parse("java.lang.Boolean", "FALSE", false);
        Object instance3 = parse("java.lang.Integer", "123", false);
        Object instance4 = parse("com.me.Color", "RED", true);
    }

    private static Object parse(String className, String argument, boolean isEnum) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        if (isEnum) {
            Object value = Enum.valueOf((Class<? extends Enum>) Class.forName(className), argument);
            //System.out.println(value);
            return value;
        } else {
            return parse(className, new Object[]{argument}, isEnum);
        }
    }

    private static Object parse(String className, Object[] arguments, boolean isEnum) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName(className);
        Constructor<?> ctor = clazz.getConstructor(String.class);
        Object object = ctor.newInstance(arguments);
        //System.out.println(object);
        return object;
    }


}
