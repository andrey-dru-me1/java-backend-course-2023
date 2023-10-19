package edu.hw2.task3.connection.manager;

import edu.hw2.task3.connection.Connection;
import edu.hw2.task3.connection.FaultyConnection;
import edu.hw2.task3.connection.StableConnection;
import java.util.concurrent.ThreadLocalRandom;

public class DefaultConnectionManager implements ConnectionManager{
    @Override public Connection getConnection() {
        if(ThreadLocalRandom.current().nextInt() % 2 == 0) return new StableConnection();
        return new FaultyConnection();
    }
}
