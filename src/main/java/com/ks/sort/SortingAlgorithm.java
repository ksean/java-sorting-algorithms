package com.ks.sort;

import java.util.List;

public interface SortingAlgorithm<E extends Comparable> {
    public List<E> sort(List<E> listToSort);
}
