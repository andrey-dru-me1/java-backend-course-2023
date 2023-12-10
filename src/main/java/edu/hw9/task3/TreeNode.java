package edu.hw9.task3;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    private final List<TreeNode<T>> children = new ArrayList<>();
    private T value;

    public TreeNode(T value) {
        this(value, List.of());
    }

    public TreeNode(List<TreeNode<T>> children) {
        this(null, children);
    }

    public TreeNode(T value, List<TreeNode<T>> children) {
        this.value = value;
        this.children.addAll(children);
    }

    public void addChild(TreeNode<T> child) {
        children.add(child);
    }

    public boolean removeChild(TreeNode<T> child) {
        return children.remove(child);
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
