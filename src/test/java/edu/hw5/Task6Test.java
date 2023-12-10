package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task6Test {

    @Test
    void test() {
        assertThat(Task6.isSubstring("achfdbaabgabcaabg", "abc")).isTrue();
        assertThat(Task6.isSubstring("achfdbaabgabaabg", "abc")).isFalse();
    }

}