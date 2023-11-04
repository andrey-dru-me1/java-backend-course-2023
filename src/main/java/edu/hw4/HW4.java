package edu.hw4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HW4 {
    public static List<Animal> task1(List<Animal> animals) {
        return animals.stream().sorted(Comparator.comparing(Animal::height)).toList();
    }
    public static List<Animal> task2(List<Animal> animals, int k) {
        return animals.stream().sorted(Comparator.comparing(Animal::weight).reversed()).limit(k).toList();
    }

    public static Map<Animal.Type, Integer> task3(List<Animal> animals) {
        Map<Animal.Type, Integer> result = new HashMap<>();
        for(Animal animal : animals) {
            result.putIfAbsent(animal.type(), 0);
            result.computeIfPresent(animal.type(), (key, value) -> value + 1);
        }
        return result;
    }
}
