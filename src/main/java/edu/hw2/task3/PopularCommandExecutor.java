package edu.hw2.task3;

import edu.hw2.task3.connection.Connection;
import edu.hw2.task3.connection.manager.ConnectionManager;

public final class PopularCommandExecutor {
  private final ConnectionManager manager;
  private final int maxAttempts;

  public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
    this.manager = manager;
    this.maxAttempts = maxAttempts;
  }

  public void updatePackages() {
    tryExecute("apt update && apt upgrade -y");
  }

  void tryExecute(String command) {
    try (Connection connection = manager.getConnection()) {
      for (int i = 0; ; i++) {
        try {
          connection.execute(command);
          break;
        } catch (ConnectionException e) {
          if (i >= maxAttempts) throw e;
        }
      }
    }
  }
}
