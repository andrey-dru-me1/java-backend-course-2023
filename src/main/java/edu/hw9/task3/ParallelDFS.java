package edu.hw9.task3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;

public class ParallelDFS {

    private ParallelDFS() {
    }

    public static <T> List<TreeNode<T>> traverseTree(TreeNode<T> tree, Predicate<T> predicate) {
        try (ForkJoinPool forkJoinPool = ForkJoinPool.commonPool()) {
            return forkJoinPool.invoke(new TreeTraverser<>(tree, predicate));
        }
    }

    private static class TreeTraverser<T> extends RecursiveTask<List<TreeNode<T>>> {

        private final TreeNode<T> treeNode;
        private final Predicate<T> predicate;

        private TreeTraverser(TreeNode<T> treeNode, Predicate<T> predicate) {
            this.treeNode = treeNode;
            this.predicate = predicate;
        }

        @Override
        protected List<TreeNode<T>> compute() {
            List<TreeNode<T>> result = new ArrayList<>();
            if (predicate.test(treeNode.getValue())) {
                result.add(treeNode);
            }

            result.addAll(ForkJoinTask.invokeAll(
                            treeNode
                                    .getChildren()
                                    .stream()
                                    .map(child -> new TreeTraverser<>(child, predicate))
                                    .toList())
                                  .stream()
                                  .map(ForkJoinTask::join)
                                  .flatMap(Collection::stream)
                                  .toList());

            return result;
        }
    }

}
