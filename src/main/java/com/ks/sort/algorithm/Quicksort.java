package com.ks.sort.algorithm;

import com.ks.sort.SortingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Quicksort<E extends Comparable> implements SortingAlgorithm<E> {

    private List<E> listToSort;

    @Override
    public List<E> sort(final List<E> listToSort) {

        int listSize = listToSort.size();

        if (listSize == 0 || listSize == 1) {
            return listToSort;
        }

        this.listToSort = listToSort;

        quicksort(0, listSize - 1);

        return this.listToSort;
    }

    private void quicksort(final int startIndex, final int endIndex) {
        // Only sort if comparing at least 2 elements
        if (startIndex < endIndex) {
            // Find the pivot
            int pivotIndex = startIndex + (int) Math.round((double)(endIndex - startIndex)/(double)2);
            E pivotValue = listToSort.get(pivotIndex);

            // Initialize the cursor
            int cursorIndex = startIndex;
            E cursorValue;

            // Sort until cursor reaches ending index
            while (cursorIndex <= endIndex) {
                // If the cursor reaches the pivot, skip the pivot index
                if (cursorIndex == pivotIndex) {
                    cursorIndex++;

                    // If cursor out of bound then break comparison loop
                    if (cursorIndex > endIndex) {
                        break;
                    }
                }

                // Refresh the cursor
                cursorValue = listToSort.get(cursorIndex);

                // Initialize booleans
                boolean isLeft = cursorIndex < pivotIndex;
                boolean adjacent = Math.abs(cursorIndex - pivotIndex) == 1;

                // Dynamic target value depending on cursor location compared to the pivot
                int targetValue = (isLeft ? 1 : -1);

                // Swap greater elements if they are left of the pivot, and lesser elements if they are right
                while (cursorValue.compareTo(pivotValue) == targetValue) {

                    // If comparing adjacent element just swap them and update the indexes
                    if (adjacent) {
                        swapElements(cursorIndex, pivotIndex);
                        pivotIndex = pivotIndex - targetValue;
                        cursorIndex = cursorIndex + targetValue;

                        break;

                    // Otherwise swap the cursor element with an adjacent index, then swap it with the pivot
                    } else {
                        swapElements(cursorIndex, pivotIndex - targetValue);
                        swapElements(pivotIndex - targetValue, pivotIndex);
                        pivotIndex = pivotIndex - targetValue;
                    }

                    // Refresh the cursor value to see if the recently swapped element is correctly located
                    cursorValue = listToSort.get(cursorIndex);
                }

                // Increment the cursor
                cursorIndex++;
            }

            // Sort starting index to pivot
            quicksort(startIndex,
                    (startIndex < pivotIndex - 1 ? pivotIndex - 1 : startIndex)
            );

            // Sort pivot to end
            quicksort((endIndex > pivotIndex + 1 ? pivotIndex + 1 : endIndex),
                    endIndex
            );
        }
    }

    private void swapElements(final int firstIndex, final int secondIndex) {
        E temporaryValue = listToSort.get(firstIndex);

        listToSort.set(firstIndex, listToSort.get(secondIndex));
        listToSort.set(secondIndex, temporaryValue);
    }
}
