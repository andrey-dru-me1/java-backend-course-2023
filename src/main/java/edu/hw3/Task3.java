package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task3 {
    private Task3() {
    }

    public static <T> Map<T, Integer> freqDict(T[] array) {
        Map<T, Integer> res = new HashMap<>();
        for(T o : array) {
            res.putIfAbsent(o, 0);
            res.put(o, res.get(o) + 1);
        }
        return res;
    }
}
