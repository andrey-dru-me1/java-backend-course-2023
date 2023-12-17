package edu.hw10.task2;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

class CacheProxy implements InvocationHandler {
    private final Object target;
    private final Map<String, Object> cache;
    private final String cacheDirectory;

    private CacheProxy(Object target, String cacheDirectory) {
        this.target = target;
        this.cache = new HashMap<>();
        this.cacheDirectory = cacheDirectory;
    }

    public static <T> T create(Object target, Class<T> interfaceClass, String cacheDirectory) {
        return (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass},
                new CacheProxy(target, cacheDirectory)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Cache.class)) {
            String key = generateCacheKey(method, args);
            if (cache.containsKey(key)) {
                return cache.get(key);
            }

            Object result = method.invoke(target, args);
            cache.put(key, result);

            Cache annotation = method.getAnnotation(Cache.class);
            if (annotation.persist()) {
                persistResult(key, result);
            }

            return result;
        } else {
            return method.invoke(target, args);
        }
    }

    private String generateCacheKey(Method method, Object[] args) {
        StringBuilder keyBuilder = new StringBuilder(method.getName());
        keyBuilder.append("_");
        for (Object arg : args) {
            keyBuilder.append(arg).append("_");
        }
        return keyBuilder.toString();
    }

    private void persistResult(String key, Object result) {
        String filePath = cacheDirectory + File.separator + key + ".ser";
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
