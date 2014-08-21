package com.ks.sort.algorithm;

import com.ks.sort.SortingAlgorithm;

import java.util.List;

public class Quicksort<E extends Comparable> implements SortingAlgorithm<E> {
    @Override
    public List<E> sort(final List<E> listToSort) {

        if (listToSort.size() == 0 || listToSort.size() == 1) {
            return listToSort;
        }

        return null;
    }
}
