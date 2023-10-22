package edu.hw2;

import edu.hw2.task3.ConnectionException;
import edu.hw2.task3.PopularCommandExecutor;
import edu.hw2.task3.connection.manager.DefaultConnectionManager;
import edu.hw2.task3.connection.manager.FaultyConnectionManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

class Task3Test {
    @Test
    @DisplayName("Удалённый сервер")
    void test() {
        assertThatNoException()
                .isThrownBy(
                        () -> new PopularCommandExecutor(new DefaultConnectionManager(), 150).updatePackages());
        assertThatNoException()
                .isThrownBy(
                        () -> new PopularCommandExecutor(new FaultyConnectionManager(), 150).updatePackages());

        boolean isThrown = false;
        try {
            for (int i = 0; i < 150; i++) {
                new PopularCommandExecutor(new FaultyConnectionManager(), 1).updatePackages();
            }
        } catch (ConnectionException e) {
            isThrown = true;
        }
        assertThat(isThrown).isTrue();
    }
}
