package edu.hw6.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {
    private final Map<String, String> inMemoryMap;
    private final Path filePath;

    public DiskMap(Path filePath) {
        this.inMemoryMap = new HashMap<>();
        this.filePath = filePath;
        loadFromFile();
    }

    private void loadFromFile() {
        File file = filePath.toFile();

        try {
            file.createNewFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] mapEntry = line.split(":");
                String key = mapEntry[0];
                String value = mapEntry[1];
                inMemoryMap.put(key, value);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException("Cannot load from file.", e);
        }

    }

    private void storeToFile() {
        File file = filePath.toFile();
        file.delete();
        try {
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, String> entry : inMemoryMap.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Cannot store to file.", e);
        }
    }

    @Override
    public int size() {
        return inMemoryMap.size();
    }

    @Override
    public boolean isEmpty() {
        return inMemoryMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return inMemoryMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return inMemoryMap.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return inMemoryMap.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        String result = inMemoryMap.put(key, value);
        storeToFile();
        return result;
    }

    @Override
    public String remove(Object key) {
        String result = inMemoryMap.remove(key);
        storeToFile();
        return result;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        inMemoryMap.putAll(m);
        storeToFile();
    }

    @Override
    public void clear() {
        inMemoryMap.clear();
        storeToFile();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return inMemoryMap.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return inMemoryMap.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return inMemoryMap.entrySet();
    }

    @Override
    public boolean equals(Object o) {
        return inMemoryMap.equals(o);
    }

    @Override
    public int hashCode() {
        return inMemoryMap.hashCode();
    }
}
