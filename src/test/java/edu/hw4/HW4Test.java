package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HW4Test {

    private final List<Animal> animals = List.of(new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 3, 5, 6, true),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 4, 4, 5, true),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.F, 2, 2, 2, false),
            new Animal("Fish1", Animal.Type.FISH, Animal.Sex.F, 1, 1, 1, false),
            new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 5, 3, 3, false),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 7, 7, 16, false),
            new Animal("Cat3", Animal.Type.CAT, Animal.Sex.F, 8, 6, 4, false),
            new Animal("Fish2", Animal.Type.FISH, Animal.Sex.M, 9, 18, 56, true));

    @Test
    void testTask1() {
        assertThat(HW4.task1(animals).stream().map(Animal::name).toList()).isEqualTo(
                List.of("Fish1", "Bird1", "Spider1", "Dog1", "Cat1", "Cat3", "Cat2", "Fish2"));
    }

    @Test
    void testTask2() {
        assertThat(HW4.task2(animals, 4).stream().map(Animal::name).toList()).isEqualTo(
                List.of("Fish2", "Cat2", "Cat1", "Dog1"));
    }

    @Test
    void testTask3() {
        assertThat(HW4.task3(animals)).isEqualTo(
                Map.of(Animal.Type.DOG, 1, Animal.Type.CAT, 3, Animal.Type.FISH, 2, Animal.Type.BIRD, 1,
                        Animal.Type.SPIDER, 1));
    }
}
