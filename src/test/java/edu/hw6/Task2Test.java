package edu.hw6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task2Test {

    @Test
    void test() throws IOException {
        Path filePath = Paths.get("pom.xml");
        File[] files = Arrays.stream(
                        new String[]{"pom — копия.xml", "pom — копия (2).xml", "pom — копия (3).xml", "pom — копия (4).xml"})
                .map((String fileName) -> Paths.get(fileName).toFile())
                .toArray(File[]::new);

        for (File file : files) {
            Task2.cloneFile(filePath);
            assertThat(file.exists()).isTrue();
        }
        for (File file : files) {
            file.delete();
        }

        assertThrows(IllegalArgumentException.class, () -> Task2.cloneFile(Paths.get("non-existent file")));

        Task2.cloneFile(Paths.get("mvnw"));
        File file = Paths.get("mvnw — копия").toFile();
        assertThat(file.exists()).isTrue();
        file.delete();
    }

}