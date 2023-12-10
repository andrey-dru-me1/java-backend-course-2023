package edu.hw9;

import edu.hw9.task3.ParallelDFS;
import edu.hw9.task3.TreeNode;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {

    @Test
    void test() {
        TreeNode<Integer> tree = new TreeNode<>(5, List.of(new TreeNode<>(6, List.of(new TreeNode<>(7),
                                                                                     new TreeNode<>(8))),
                                                           new TreeNode<>(8)));
        assertThat(ParallelDFS.traverseTree(tree, i -> i == 8).size()).isEqualTo(2);
    }

}
