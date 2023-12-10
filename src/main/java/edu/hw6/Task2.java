package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Task2 {

    private Task2() {
    }

    private static final String COPY_STRING = " — копия";

    public static void cloneFile(Path filePath) throws IOException {
        if (!filePath.toFile().exists()) {
            throw new IllegalArgumentException("File does not exist");
        }
        String fileName = filePath.getFileName().toString();
        int lastPeriodIndex = fileName.lastIndexOf(".");
        if (lastPeriodIndex == -1) {
            lastPeriodIndex = fileName.length();
        }
        String copyFileName =
                fileName.substring(0, lastPeriodIndex) + COPY_STRING + fileName.substring(lastPeriodIndex);
        Path copyFilePath = filePath.resolveSibling(copyFileName);

        lastPeriodIndex += COPY_STRING.length();
        for (int i = 2; copyFilePath.toFile().exists(); i++) {
            String indexedCopyFileName =
                    copyFileName.substring(0, lastPeriodIndex) + " (" + i + ")" + copyFileName.substring(
                            lastPeriodIndex);
            copyFilePath = filePath.resolveSibling(indexedCopyFileName);
        }

        Files.copy(filePath, copyFilePath, StandardCopyOption.REPLACE_EXISTING);
    }

}
