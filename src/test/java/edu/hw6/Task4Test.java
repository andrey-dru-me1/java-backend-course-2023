package edu.hw6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task4Test {

    @Test
    void test() throws IOException {
        Path path = Paths.get("src", "main", "resources", "wise-saying.txt");
        File file = path.toFile();
        file.delete();
        Task4.writeToFile(path);
        assertThat(file.exists()).isTrue();
        assertThat(new Scanner(file).nextLine()).isEqualTo(
                "Programming is learned by writing programs. ― Brian Kernighan");
        file.delete();
    }

}