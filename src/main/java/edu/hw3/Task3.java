package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task3 {
    private Task3() {
    }

    public static <T> Map<T, Integer> freqDict(T[] array) {
        Map<T, Integer> result = new HashMap<>();
        for (T o : array) {
            result.putIfAbsent(o, 0);
            result.put(o, result.get(o) + 1);
        }
        return result;
    }
}
