package com.ks.sort.algorithm;

import com.ks.sort.SortingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Bubblesort<E extends Comparable> implements SortingAlgorithm<E> {

    @Override
    public List<E> sort(final List<E> listToSort) {

        if (listToSort.size() == 0 || listToSort.size() == 1) {
            return listToSort;
        }

        List<E> cursorList = new ArrayList<>(listToSort);

        boolean swapped = true;

        while (swapped) {
            swapped = false;

            for (int i = 0; i < cursorList.size() - 1; i++) {

                if (cursorList.get(i).compareTo(cursorList.get(i + 1)) > 0) {
                    swapped = true;

                    E temporaryElement = cursorList.get(i);

                    cursorList.set(i, cursorList.get(i + 1));
                    cursorList.set(i + 1, temporaryElement);
                }
            }
        }

        return cursorList;
    }
}
