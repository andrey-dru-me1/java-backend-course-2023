package edu.hw7.task3;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SynchronizedPersonDatabase extends AbstractPersonDatabase implements PersonDatabase {

    @Override
    public synchronized void add(Person person) {
        super.add(person);
    }

    @Override
    public synchronized void delete(int id) {
        super.delete(id);
    }

    protected synchronized List<Person> find(Map<String, Set<Integer>> index, String key) {
        return super.find(index, key);
    }
}

