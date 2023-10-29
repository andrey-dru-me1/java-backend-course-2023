package edu.hw3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task5Test {

    @Test
    void parseContacts() {
        assertThat(Task5.parseContacts(new String[]{"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"},
                "ASC")).isEqualTo(new String[]{"Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke"});
        assertThat(Task5.parseContacts(new String[]{"Paul Erdos", "Leonhard Euler", "Carl Gauss"}, "DESC")).isEqualTo(
                new String[]{"Carl Gauss", "Leonhard Euler", "Paul Erdos"});
        assertThat(Task5.parseContacts(new String[]{}, "DESC")).isEqualTo(new String[]{});
        assertThat(Task5.parseContacts(null, "DESC")).isEqualTo(new String[]{});
        assertThat(Task5.parseContacts(new String[]{"Paul Erdos", "Euler", "Carl Gauss"}, "DESC")).isEqualTo(
                new String[]{"Carl Gauss", "Euler", "Paul Erdos"});
    }
}