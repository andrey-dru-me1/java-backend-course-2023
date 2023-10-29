package edu.hw3.task8;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class BackwardIterator<E, T extends Collection<E>> implements Iterator<E> {
    private final ListIterator<E> iterator;
    public BackwardIterator(T collection) {
        this.iterator = collection.stream().toList().listIterator(collection.size());
    }

    @Override
    public boolean hasNext() {
        return iterator.hasPrevious();
    }

    @Override
    public E next() {
        return iterator.previous();
    }
}
