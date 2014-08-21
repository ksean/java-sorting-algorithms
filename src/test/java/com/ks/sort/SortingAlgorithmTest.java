package com.ks.sort;

import com.ks.sort.algorithm.Bubblesort;
import com.ks.sort.algorithm.Quicksort;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SortingAlgorithmTest {

    public SortingAlgorithm<Integer> sortingAlgorithm;

    private List<Integer> preSortedList = new ArrayList<>();
    private List<Integer> unSortedList = new ArrayList<>();

    public SortingAlgorithmTest(SortingAlgorithm<Integer> sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> sortingAlgorithms() {
        return Arrays.asList(
                new Object[]{new Bubblesort<Integer>()},
                new Object[]{new Quicksort<Integer>()}
        );
    }

    @Before
    public void setup() {
        preSortedList.add(1);
        preSortedList.add(2);
        preSortedList.add(3);

        unSortedList.add(3);
        unSortedList.add(2);
        unSortedList.add(1);
    }

    @Test
    public void sortEmptyListReturnsSameList() {
        // Setup
        List<Integer> listToSort = new ArrayList<>();

        // Actions
        List<Integer> sortedList = sortingAlgorithm.sort(listToSort);

        // Assertions
        assertEquals(listToSort, sortedList);
    }

    @Test
    public void sortSizeOneListReturnsSameList() {
        // Setup
        List<Integer> listToSort = new ArrayList<>();

        // Actions
        listToSort.add(1);
        List<Integer> sortedList = sortingAlgorithm.sort(listToSort);

        // Assertions
        assertEquals(listToSort, sortedList);
    }

    @Test
    public void sortPreSortedListReturnsSameList() {
        // Actions
        List<Integer> sortedList = sortingAlgorithm.sort(preSortedList);

        // Assertions
        assertEquals(preSortedList, sortedList);
    }

    @Test
    public void sortUnsortedListReturnsSortedList() {
        // Actions
        List<Integer> sortedList = sortingAlgorithm.sort(unSortedList);

        // Assertions
        assertEquals(preSortedList, sortedList);
    }
}
