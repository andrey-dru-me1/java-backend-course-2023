package edu.hw3;

import java.util.List;

@SuppressWarnings("magicnumber")
public class Task4 {
    private static final List<Point<Integer, String>> ROMAN_UNITS =
            List.of(new Point<>(1, "I"), new Point<>(4, "IV"), new Point<>(5, "V"), new Point<>(9, "IX"),
                    new Point<>(10, "X"), new Point<>(40, "XL"), new Point<>(50, "L"), new Point<>(90, "XC"),
                    new Point<>(100, "C"), new Point<>(400, "CD"), new Point<>(500, "D"), new Point<>(900, "CM"),
                    new Point<>(1000, "M")).reversed();

    private Task4() {
    }

    public static String convertToRoman(int number) {
        int num = number;
        if (!(num > 0 && num < 4000)) {
            throw new IllegalArgumentException();
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {
            int i = 0;
            while (i < ROMAN_UNITS.size() && ROMAN_UNITS.get(i).key() > num) {
                i++;
            }
            stringBuilder.append(ROMAN_UNITS.get(i).val());
            num -= ROMAN_UNITS.get(i).key;
        }
        return stringBuilder.toString();
    }

    private record Point<K, V>(K key, V val) {
    }
}
