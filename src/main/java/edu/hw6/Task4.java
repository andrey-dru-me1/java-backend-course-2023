package edu.hw6;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.CRC32C;
import java.util.zip.CheckedOutputStream;

public class Task4 {

    private Task4() {
    }

    private final static String MESSAGE = "Programming is learned by writing programs. ― Brian Kernighan";

    public static void writeToFile(Path path) throws IOException {
        try (OutputStream outputStream = Files.newOutputStream(
                path); CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream,
                new CRC32C()); BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                checkedOutputStream); OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                bufferedOutputStream); PrintWriter printWriter = new PrintWriter(outputStreamWriter)) {

            printWriter.println(MESSAGE);
        }
    }

}
