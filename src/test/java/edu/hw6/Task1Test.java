package edu.hw6;

import edu.hw6.task1.DiskMap;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    void test() {
        Path path = Paths.get("src", "main", "resources", "map.dat");
        path.toFile().delete();

        Map<String, String> map = new DiskMap(path);
        map.put("lol", "kek");
        map.putAll(Map.of("dog", "bark", "bird", "tweet", "cat", "meow"));
        map.remove("dog");

        Map<String, String> expected = Map.of("lol", "kek", "bird", "tweet", "cat", "meow");
        map = new DiskMap(path);
        assertThat(map).isEqualTo(expected);

        map.clear();
        map = new DiskMap(path);
        assertThat(map.isEmpty()).isTrue();

        path.toFile().delete();
    }

}
