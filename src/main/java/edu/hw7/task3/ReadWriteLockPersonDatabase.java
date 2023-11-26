package edu.hw7.task3;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockPersonDatabase extends AbstractPersonDatabase implements PersonDatabase {
    protected final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public void add(Person person) {
        Lock writeLock = lock.writeLock();
        writeLock.lock();
        try {
            super.add(person);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void delete(int id) {
        Lock writeLock = lock.writeLock();
        writeLock.lock();
        try {
            super.delete(id);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    protected List<Person> find(Map<String, Set<Integer>> index, String key) {
        Lock readLock = lock.readLock();
        readLock.lock();
        try {
            return super.find(index, key);
        } finally {
            readLock.unlock();
        }
    }
}

