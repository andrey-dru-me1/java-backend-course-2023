package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HW4 {
    public static List<Animal> task1(List<Animal> animals) {
        return animals.stream().sorted(Comparator.comparing(Animal::height)).toList();
    }

    public static List<Animal> task2(List<Animal> animals, int k) {
        return animals.stream().sorted(Comparator.comparing(Animal::weight).reversed()).limit(k).toList();
    }

    public static Map<Animal.Type, Integer> task3(List<Animal> animals) {
        return animals.stream()
                .collect(Collectors.groupingBy(Animal::type, Collectors.reducing(0, e -> 1, Integer::sum)));
    }

    public static Animal task4(List<Animal> animals) {
        return animals.stream().max(Comparator.comparing((Animal animal) -> animal.name().length())).orElseThrow();
    }

    public static Animal.Sex task5(List<Animal> animals) {
        long maleCount = animals.stream().filter((Animal animal) -> animal.sex() == Animal.Sex.M).count();
        long femaleCount = animals.stream().filter((Animal animal) -> animal.sex() == Animal.Sex.F).count();
        if (maleCount == femaleCount) {
            return null;
        }
        return (maleCount > femaleCount) ? Animal.Sex.M : Animal.Sex.F;
    }

    public static Map<Animal.Type, Animal> task6(List<Animal> animals) {
        return animals.stream()
                .collect(Collectors.toMap(Animal::type, Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(Animal::weight))));
    }
}
