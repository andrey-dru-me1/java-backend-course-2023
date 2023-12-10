package edu.hw9;

import edu.hw9.task2.ParallelTreeProcessing;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task2Test {

    @Test
    void testBigDirectorySearcher() throws IOException {
        File bigDir = new File("testDir");
        bigDir.mkdir();
        for (int i = 0; i < 1050; i++) {
            File file = Paths.get("testDir", "File" + i).toFile();
            file.createNewFile();
        }

        assertThat(ParallelTreeProcessing.searchBigDirectories(new File(".")).stream().map(file -> {
            try {
                return file.getCanonicalPath();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).toList()).isEqualTo(List.of(bigDir.getCanonicalPath()));

        for (File file : bigDir.listFiles()) {
            file.delete();
        }
        bigDir.delete();

        assertThat(ParallelTreeProcessing.searchBigDirectories(new File("."))).isEmpty();
    }

    @Test
    void testPredicateFilesSearcher() {
        assertThat(ParallelTreeProcessing.searchByPredicate(new File("."), file -> file.getName()
                .equals("ParallelTreeProcessing.java")).size()).isEqualTo(1);
    }

}