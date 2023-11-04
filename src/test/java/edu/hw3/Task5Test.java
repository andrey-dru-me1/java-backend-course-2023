package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task5Test {

    @Test
    void testParseContacts() {
        assertThat(Task5.parseContacts(new String[]{"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"},
                "ASC")).isEqualTo(
                Arrays.stream(new String[]{"Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke"})
                        .map(Task5.Contact::new)
                        .toArray(Task5.Contact[]::new));

        assertThat(Task5.parseContacts(new String[]{"Paul Erdos", "Leonhard Euler", "Carl Gauss"}, "DESC")).isEqualTo(
                Arrays.stream(new String[]{"Carl Gauss", "Leonhard Euler", "Paul Erdos"})
                        .map(Task5.Contact::new)
                        .toArray(Task5.Contact[]::new));

        assertThat(Task5.parseContacts(new String[]{}, "DESC")).isEqualTo(new Task5.Contact[]{});

        assertThat(Task5.parseContacts(null, "DESC")).isEqualTo(new Task5.Contact[]{});

        assertThat(Task5.parseContacts(new String[]{"Paul Erdos", "Euler", "Carl Gauss"}, "DESC")).isEqualTo(
                Arrays.stream(new String[]{"Carl Gauss", "Euler", "Paul Erdos"})
                        .map(Task5.Contact::new)
                        .toArray(Task5.Contact[]::new));

        assertThrows(IllegalArgumentException.class,
                () -> Task5.parseContacts(new String[]{"Paul Erdos", "Euler", "Carl Gauss"}, "ABC"));
    }
}