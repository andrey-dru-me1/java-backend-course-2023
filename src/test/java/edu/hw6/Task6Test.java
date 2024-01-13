package edu.hw6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @Test
    void test() {
        assertDoesNotThrow(Task6::printPortsInUse);
    }

}