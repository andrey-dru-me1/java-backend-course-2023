package edu.hw3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Task5 {
    private static final String ASC = "ASC";
    private static final String DESC = "DESC";

    private Task5() {
    }

    public static Contact[] parseContacts(String[] contacts, String ordering) {
        if (contacts == null) {
            return new Contact[]{};
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
        return Arrays.stream(contacts).sorted(comp).map(Contact::new).toArray(Contact[]::new);
    }

    public static class Contact {
        private final String firstName;
        private final String lastName;

        public Contact(String name) {
            String[] tokens = name.split(" ");
            firstName = tokens[0];
            lastName = (tokens.length > 1) ? tokens[1] : null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Contact contact)) {
                return false;
            }
            return Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName);
        }

        @Override
        public String toString() {
            return firstName + ((lastName == null) ? "" : " " + lastName);
        }

    }
}
