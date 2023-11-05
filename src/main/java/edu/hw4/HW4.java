package edu.hw4;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HW4 {

    private HW4() {
    }

    // Отсортировать животных по росту от самого маленького к самому большому -> List<Animal>
    public static List<Animal> task1(List<Animal> animals) {
        return animals.stream().sorted(Comparator.comparing(Animal::height)).toList();
    }

    // Отсортировать животных по весу от самого тяжелого к самому легкому, выбрать k первых -> List<Animal>
    public static List<Animal> task2(List<Animal> animals, int k) {
        return animals.stream().sorted(Comparator.comparing(Animal::weight).reversed()).limit(k).toList();
    }

    // Сколько животных каждого вида -> Map<Animal.Type, Integer>
    public static Map<Animal.Type, Integer> task3(List<Animal> animals) {
        return animals.stream()
                .collect(Collectors.groupingBy(Animal::type, Collectors.reducing(0, e -> 1, Integer::sum)));
    }

    // У какого животного самое длинное имя -> Animal
    public static Animal task4(List<Animal> animals) {
        return animals.stream().max(Comparator.comparing((Animal animal) -> animal.name().length())).orElseThrow();
    }

    // Каких животных больше: самцов или самок -> Sex
    public static Animal.Sex task5(List<Animal> animals) {
        long maleCount = animals.stream().filter((Animal animal) -> animal.sex() == Animal.Sex.M).count();
        long femaleCount = animals.stream().filter((Animal animal) -> animal.sex() == Animal.Sex.F).count();
        if (maleCount == femaleCount) {
            return null;
        }
        return (maleCount > femaleCount) ? Animal.Sex.M : Animal.Sex.F;
    }

    // Самое тяжелое животное каждого вида -> Map<Animal.Type, Animal>
    public static Map<Animal.Type, Animal> task6(List<Animal> animals) {
        return animals.stream()
                .collect(Collectors.toMap(Animal::type, Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(Animal::weight))));
    }

    // K-е самое старое животное -> Animal
    public static Animal task7(List<Animal> animals, int k) {
        return animals.stream().sorted(Comparator.comparing(Animal::age).reversed()).toList().get(k - 1);
    }

    // Самое тяжелое животное среди животных ниже k см -> Optional<Animal>
    public static Animal task8(List<Animal> animals, int k) {
        return animals.stream()
                .filter((Animal animal) -> animal.height() < k)
                .max(Comparator.comparing(Animal::weight))
                .orElseThrow();
    }

    // Сколько в сумме лап у животных в списке -> Integer
    public static Integer task9(List<Animal> animals) {
        return animals.stream()
                .reduce(0, (Integer accumulator, Animal animal) -> accumulator + animal.paws(), Integer::sum);
    }

    // Список животных, возраст у которых не совпадает с количеством лап -> List<Animal>
    public static List<Animal> task10(List<Animal> animals) {
        return animals.stream().filter((Animal animal) -> animal.paws() != animal.age()).toList();
    }

    // Список животных, которые могут укусить (bites == true) и рост которых превышает 100 см -> List<Animal>
    @SuppressWarnings("magicnumber")
    public static List<Animal> task11(List<Animal> animals) {
        return animals.stream().filter((Animal animal) -> animal.bites() && animal.height() > 100).toList();
    }

    // Сколько в списке животных, вес которых превышает рост -> Integer
    public static Integer task12(List<Animal> animals) {
        return Long.valueOf(animals.stream().filter((Animal animal) -> animal.weight() > animal.height()).count())
                .intValue();
    }

    // Список животных, имена которых состоят из более чем двух слов -> List<Animal>
    public static List<Animal> task13(List<Animal> animals) {
        return animals.stream().filter((Animal animal) -> animal.name().split(" ").length > 2).toList();
    }

    // Есть ли в списке собака ростом более k см -> Boolean
    public static Boolean task14(List<Animal> animals, int k) {
        return animals.stream().anyMatch((Animal animal) -> animal.type() == Animal.Type.DOG && animal.height() > k);
    }

    // Найти суммарный вес животных каждого вида, которым от k до l лет -> Map<Animal.Type, Integer>
    public static Map<Animal.Type, Integer> task15(List<Animal> animals, int k, int l) {
        return animals.stream()
                .collect(Collectors.groupingBy(Animal::type, Collectors.reducing(0,
                        (Animal animal) -> ((animal.age() >= k && animal.age() < l) ? animal.weight() : 0),
                        Integer::sum)));
    }

    // Список животных, отсортированный по виду, затем по полу, затем по имени -> List<Animal>
    public static List<Animal> task16(List<Animal> animals) {
        return animals.stream()
                .sorted(Comparator.comparing(Animal::type).thenComparing(Animal::sex).thenComparing(Animal::name))
                .toList();
    }

    // Правда ли, что пауки кусаются чаще, чем собаки -> Boolean (если данных для ответа недостаточно, вернуть false)
    public static Boolean task17(List<Animal> animals) {
        List<Animal> spiders = animals.stream().filter((Animal animal) -> animal.type() == Animal.Type.SPIDER).toList();
        List<Animal> dogs = animals.stream().filter((Animal animal) -> animal.type() == Animal.Type.DOG).toList();

        if (spiders.isEmpty() || dogs.isEmpty()) {
            return false;
        }

        long spiderBitesCount = spiders.stream().filter(Animal::bites).count();
        long dogBitesCount = dogs.stream().filter(Animal::bites).count();

        return (double) spiderBitesCount / spiders.size() > (double) dogBitesCount / dogs.size();
    }

    // Найти самую тяжелую рыбку в 2-х или более списках -> Animal
    public static Animal task18(List<List<Animal>> animalLists) {
        Comparator<Animal> fishComparator = Comparator.comparing(Animal::weight);
        return animalLists.stream()
                .map((List<Animal> animalList) -> animalList.stream()
                        .filter((Animal animal) -> animal.type() == Animal.Type.FISH)
                        .max(fishComparator)
                        .orElseThrow())
                .max(fishComparator)
                .orElseThrow();
    }

    // Животные, в записях о которых есть ошибки: вернуть имя и список ошибок -> Map<String, Set<ValidationError>>.
    public static Map<String, Set<ValidationError>> task19(List<Animal> animals) {
        return animals.stream().collect(Collectors.toMap(Animal::name, (Animal animal) -> {
            Set<ValidationError> result = new HashSet<>();
            if (animal.age() < 0) {
                result.add(ValidationError.INCORRECT_AGE);
            }
            if (animal.weight() <= 0) {
                result.add(ValidationError.INCORRECT_WEIGHT);
            }
            if (animal.height() <= 0) {
                result.add(ValidationError.INCORRECT_HEIGHT);
            }
            return result;
        }));
    }
}
