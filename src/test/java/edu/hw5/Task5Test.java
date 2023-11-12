package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task5Test {

    @Test
    void test() {
        assertThat(Task5.validateLicensePlate("А123ВЕ777")).isTrue();
        assertThat(Task5.validateLicensePlate("О777ОО177")).isTrue();
        assertThat(Task5.validateLicensePlate("123АВЕ777")).isFalse();
        assertThat(Task5.validateLicensePlate("А123ВГ77")).isFalse();
        assertThat(Task5.validateLicensePlate("А123ВЕ7777")).isFalse();
    }

}