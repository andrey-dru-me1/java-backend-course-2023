package edu.hw3;

import java.util.Arrays;
import java.util.Comparator;

public class Task5 {
    private static final String ASC = "ASC";
    private static final String DESC = "DESC";

    private Task5() {
    }

    public static Object[] parseContacts(String[] contacts, String ordering) {
        if (contacts == null) {
            return new String[]{};
        }
        if (!(ordering.equals(ASC) || ordering.equals(DESC))) {
            throw new IllegalArgumentException(
                    "Argument `ordering` should match either " + ASC + " or " + DESC + " string");
        }
        Comparator<String> comp = Comparator.comparing(n -> {
            String[] tokens = n.split(" ");
            return tokens.length > 1 ? tokens[1] : tokens[0];
        });
        if (ordering.equals(DESC)) {
            comp = comp.reversed();
        }
        return Arrays.stream(contacts).sorted(comp).toArray();
    }
}
