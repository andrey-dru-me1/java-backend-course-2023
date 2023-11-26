package edu.hw7.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractPersonDatabase implements PersonDatabase {
    protected final Map<Integer, Person> idToPersonMap = new HashMap<>();
    protected final Map<String, Set<Integer>> nameIndex = new HashMap<>();
    protected final Map<String, Set<Integer>> addressIndex = new HashMap<>();
    protected final Map<String, Set<Integer>> phoneIndex = new HashMap<>();

    @Override
    public void add(Person person) {
        idToPersonMap.put(person.id(), person);
        addToIndex(nameIndex, person.name(), person.id());
        addToIndex(addressIndex, person.address(), person.id());
        addToIndex(phoneIndex, person.phoneNumber(), person.id());
    }

    @Override
    public void delete(int id) {
        Person person = idToPersonMap.remove(id);
        removeFromIndex(nameIndex, person.name(), id);
        removeFromIndex(addressIndex, person.address(), id);
        removeFromIndex(phoneIndex, person.phoneNumber(), id);
    }

    @Override
    public List<Person> findByName(String name) {
        return find(nameIndex, name);
    }

    @Override
    public List<Person> findByAddress(String address) {
        return find(addressIndex, address);
    }

    @Override
    public List<Person> findByPhone(String phone) {
        return find(phoneIndex, phone);
    }

    protected void addToIndex(Map<String, Set<Integer>> index, String key, int id) {
        index.computeIfAbsent(key, k -> new HashSet<>()).add(id);
    }

    protected void removeFromIndex(Map<String, Set<Integer>> index, String key, int id) {
        index.computeIfPresent(key, (k, ids) -> {
            ids.remove(id);
            if (ids.isEmpty()) {
                return null; // Remove the key if there are no associated ids
            }
            return ids;
        });
    }

    protected List<Person> find(Map<String, Set<Integer>> index, String key) {
        Set<Integer> ids = index.get(key);
        if (ids != null) {
            List<Person> result = new ArrayList<>();
            for (int id : ids) {
                result.add(idToPersonMap.get(id));
            }
            return result;
        } else {
            return Collections.emptyList();
        }
    }

}
