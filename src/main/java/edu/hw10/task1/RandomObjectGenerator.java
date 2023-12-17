package edu.hw10.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

class RandomObjectGenerator {
    private final Random random = new Random();

    public <T> T nextObject(Class<T> clazz, String factoryMethod) throws Exception {
        if (clazz.isRecord()) {
            return generateRecord(clazz);
        } else {
            return generatePojo(clazz, factoryMethod);
        }
    }

    private <T> T generateRecord(Class<T> clazz) throws Exception {
        // TODO: generation for Record objects
        return null;
    }

    private <T> T generatePojo(Class<T> clazz, String factoryMethod) throws Exception {
        Constructor<T> constructor;
        if (factoryMethod != null) {
            Method method = clazz.getMethod(factoryMethod);
            return (T) method.invoke(null);
        } else {
            constructor = clazz.getConstructor();
        }

        T instance = constructor.newInstance();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(NotNull.class)) {
                field.set(instance, generateValue(field.getType()));
            } else if (field.isAnnotationPresent(Min.class)) {
                int minValue = field.getAnnotation(Min.class).value();
                field.set(instance, Math.max(minValue, (Integer) generateValue(field.getType())));
            } else if (field.isAnnotationPresent(Max.class)) {
                int maxValue = field.getAnnotation(Max.class).value();
                field.set(instance, Math.min(maxValue, (Integer) generateValue(field.getType())));
            } else {
                field.set(instance, generateValue(field.getType()));
            }
        }

        return instance;
    }

    private Object generateValue(Class<?> fieldType) {
        if (fieldType == int.class || fieldType == Integer.class) {
            return random.nextInt();
        } else if (fieldType == long.class || fieldType == Long.class) {
            return random.nextLong();
        } else if (fieldType == double.class || fieldType == Double.class) {
            return random.nextDouble();
        } else if (fieldType == float.class || fieldType == Float.class) {
            return random.nextFloat();
        } else if (fieldType == boolean.class || fieldType == Boolean.class) {
            return random.nextBoolean();
        } else if (fieldType == char.class || fieldType == Character.class) {
            return (char) (random.nextInt(26) + 'a');
        } else {
            return null;
        }
    }
}
