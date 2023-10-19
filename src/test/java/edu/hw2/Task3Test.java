package edu.hw2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import edu.hw2.task3.PopularCommandExecutor;
import edu.hw2.task3.connection.manager.DefaultConnectionManager;
import edu.hw2.task3.connection.manager.FaultyConnectionManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
  }
}
