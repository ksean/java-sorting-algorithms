package com.ks.sort.algorithm;

import com.ks.sort.SortingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Insertionsort<E extends Comparable> implements SortingAlgorithm<E> {

    private List<E> newList;

    @Override
    public List<E> sort(final List<E> listToSort) {

        if (listToSort.size() == 0 || listToSort.size() == 1) {
            return listToSort;
        }

        newList = new ArrayList<>();

        for (E element : listToSort) {
            insertionSort(element);
        }

        return newList;
    }

    private void insertionSort(E insertElement) {
        int listSize = newList.size();

        // Iterate through all elements
        for (int i = 0; i <= listSize; i++) {
            // If adding first element or reached end, just add it
            if (listSize == 0 || i == listSize) {
                newList.add(insertElement);
                break;

            // If insertElement is less than the compared element, add it before the compared element
            } else if (insertElement.compareTo(newList.get(i)) == -1) {
                newList.add(i, insertElement);
                break;
            }
        }
    }
}
