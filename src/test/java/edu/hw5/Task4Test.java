package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task4Test {

    @Test
    void test() {
        assertThat(Task4.check("absde^fhjk")).isTrue();
        assertThat(Task4.check("absde*fhjk")).isTrue();
        assertThat(Task4.check("absde%fhjk")).isTrue();
        assertThat(Task4.check("absde$fhjk")).isTrue();
        assertThat(Task4.check("absde#fhjk")).isTrue();
        assertThat(Task4.check("absde@fhjk")).isTrue();
        assertThat(Task4.check("absde!fhjk")).isTrue();
        assertThat(Task4.check("absde~fhjk")).isTrue();
        assertThat(Task4.check("absde|fhjk")).isTrue();
        assertThat(Task4.check("absdefhjk")).isFalse();
    }

}