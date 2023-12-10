package edu.hw6;

import edu.hw6.task3.AbstractFilter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task3Test {

    @Test
    void test() throws IOException {
        DirectoryStream.Filter<Path> filter = ((AbstractFilter) Files::isRegularFile).and(Files::isReadable)
                .and(AbstractFilter.largerThan(100_000))
                .and(AbstractFilter.magicNumber((byte) 0x89, (byte) 'P', (byte) 'N', (byte) 'G'))
                .and(AbstractFilter.globMatches("*.png"))
                .and(AbstractFilter.regexContains(".*[-].*"));

        List<Path> result = new ArrayList<>();

        Path dir = Paths.get("src", "main", "resources");
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir,
                filter)) {
            entries.forEach(result::add);
        }
        assertThat(result).isEqualTo(List.of(dir.resolve("pic-test.png")));
    }

}