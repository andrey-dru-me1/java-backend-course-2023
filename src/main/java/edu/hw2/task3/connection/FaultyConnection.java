package edu.hw2.task3.connection;

import edu.hw2.task3.ConnectionException;
import java.util.concurrent.ThreadLocalRandom;

public class FaultyConnection implements Connection {
    @Override
    public void execute(String command) {
        if (ThreadLocalRandom.current().nextInt() % 2 == 0) {
            throw new ConnectionException();
        }
    }
}
