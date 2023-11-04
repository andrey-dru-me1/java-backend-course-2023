package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HW4Test {

    private final List<Animal> animals = List.of(new Animal("Cat1", Animal.Type.CAT, Animal.Sex.F, 3, 5, 6, true),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 4, 4, 5, true),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.F, 2, 2, 2, false),
            new Animal("F sh 1", Animal.Type.FISH, Animal.Sex.F, 1, 1, 1, false),
            new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 5, 3, 3, false),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 7, 170, 16, false),
            new Animal("C at 3", Animal.Type.CAT, Animal.Sex.F, 8, 6, 4, false),
            new Animal("Fish2", Animal.Type.FISH, Animal.Sex.M, 9, 180, 56, true));

    @Test
    void testTask1() {
        assertThat(HW4.task1(animals).stream().map(Animal::name).toList()).isEqualTo(
                List.of("F sh 1", "Bird1", "Spider1", "Dog1", "Cat1", "C at 3", "Cat2", "Fish2"));
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

    @Test
    void testTask4() {
        assertThat(HW4.task4(animals).name()).isEqualTo("Spider1");
    }

    @Test
    void testTask5() {
        assertThat(HW4.task5(animals)).isEqualTo(Animal.Sex.F);
    }

    @Test
    void testTask6() {
        assertThat(HW4.task6(animals)).isEqualTo(
                Map.of(Animal.Type.DOG, animals.get(1), Animal.Type.CAT, animals.get(5), Animal.Type.FISH,
                        animals.get(7), Animal.Type.BIRD, animals.get(2), Animal.Type.SPIDER, animals.get(4)));
    }

    @Test
    void testTask7() {
        assertThat(HW4.task7(animals, 5).name()).isEqualTo("Dog1");
    }

    @Test
    void testTask8() {
        assertThat(HW4.task8(animals, 5).name()).isEqualTo("Dog1");
    }

    @Test
    void testTask9() {
        assertThat(HW4.task9(animals)).isEqualTo(26);
    }

    @Test
    void testTask10() {
        assertThat(HW4.task10(animals).size()).isEqualTo(6);
    }

    @Test
    void testTask11() {
        assertThat(HW4.task11(animals).size()).isEqualTo(1);
    }

    @Test
    void testTask12() {
        assertThat(HW4.task12(animals)).isEqualTo(2);
    }

    @Test
    void testTask13() {
        assertThat(HW4.task13(animals).size()).isEqualTo(2);
    }

    @Test
    void testTask14() {
        assertThat(HW4.task14(animals, 4)).isFalse();
        assertThat(HW4.task14(animals, 3)).isTrue();
    }

    @Test
    void testTask15() {
        assertThat(HW4.task15(animals, 2, 8)).isEqualTo(
                Map.of(Animal.Type.DOG, 5, Animal.Type.CAT, 22, Animal.Type.FISH, 0, Animal.Type.BIRD, 2,
                        Animal.Type.SPIDER, 3));
    }

    @Test
    void testTask16() {
        assertThat(HW4.task16(animals).stream().map(Animal::name).toList()).isEqualTo(
                List.of("C at 3", "Cat1", "Cat2", "Dog1", "Bird1", "Fish2", "F sh 1", "Spider1"));
    }

    @Test
    void testTask17() {
        assertThat(HW4.task17(animals)).isFalse();
        assertThat(HW4.task17(List.of())).isFalse();
        assertThat(HW4.task17(List.of(new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.F, 0, 0, 0, true),
                new Animal("Spider2", Animal.Type.SPIDER, Animal.Sex.F, 0, 0, 0, false),
                new Animal("Dog1", Animal.Type.DOG, Animal.Sex.F, 0, 0, 0, true),
                new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 0, 0, 0, false),
                new Animal("Dog3", Animal.Type.DOG, Animal.Sex.F, 0, 0, 0, false)))).isTrue();
    }
}
