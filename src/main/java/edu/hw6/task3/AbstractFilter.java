package edu.hw6.task3;

import java.io.FileInputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {

    static AbstractFilter largerThan(int size) {
        return (Path path) -> Files.size(path) > size;
    }

    static AbstractFilter globMatches(String glob) {
        return (Path path) -> FileSystems.getDefault().getPathMatcher("glob:" + glob).matches(path.getFileName());
    }

    static AbstractFilter regexContains(String regex) {
        return (Path path) -> path.getFileName().toString().matches(regex);
    }

    static AbstractFilter magicNumber(byte... magicBytes) {
        byte[] buffer = new byte[magicBytes.length];
        return (Path path) -> {
            try (FileInputStream fis = new FileInputStream(path.toFile())) {
                int bytesRead = fis.read(buffer, 0, buffer.length);
                if (bytesRead < buffer.length) {
                    return false;
                }
                for (int i = 0; i < buffer.length; i++) {
                    if (buffer[i] != magicBytes[i]) {
                        return false;
                    }
                }
                return true;
            }
        };
    }

    default AbstractFilter and(AbstractFilter filter) {
        return (Path path) -> this.accept(path) && filter.accept(path);
    }

}
