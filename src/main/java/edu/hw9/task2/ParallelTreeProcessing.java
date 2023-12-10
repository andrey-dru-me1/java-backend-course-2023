package edu.hw9.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;

public class ParallelTreeProcessing {

    private static final int BIG_NUMBER = 1_000;

    public static List<File> searchBigDirectories(File initDirectory) {
        return searchByPredicate(initDirectory, file -> file.isDirectory()
                && Objects.requireNonNull(file.listFiles()).length > BIG_NUMBER);
    }

    public static List<File> searchByPredicate(File initDirectory, Predicate<File> predicate) {
        if (!initDirectory.isDirectory()) {
            throw new IllegalArgumentException("Directory should be passed");
        }

        try (ForkJoinPool forkJoinPool = ForkJoinPool.commonPool()) {
            return forkJoinPool.invoke(new PredicateFileSearcher(initDirectory, predicate));
        }
    }

    private static class PredicateFileSearcher extends RecursiveTask<List<File>> {

        private final File directory;
        private final Predicate<File> predicate;

        public PredicateFileSearcher(File directory, Predicate<File> predicate) {
            this.directory = directory;
            this.predicate = predicate;
        }

        @Override
        protected List<File> compute() {
            List<File> result = new ArrayList<>();

            List<PredicateFileSearcher> directorySearchers = new ArrayList<>();
            File[] files = directory.listFiles();
            for (File file : files) {
                if (predicate.test(file)) {
                    result.add(file);
                }
                if (file.isDirectory()) {
                    directorySearchers.add(new PredicateFileSearcher(file, predicate));
                }
            }

            result.addAll(ForkJoinTask.invokeAll(directorySearchers)
                                  .stream()
                                  .map(ForkJoinTask::join)
                                  .flatMap(Collection::stream)
                                  .toList());
            return result;
        }
    }

}
