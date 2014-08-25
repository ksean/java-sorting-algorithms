package com.ks.sort;

import com.ks.sort.algorithm.*;

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

    private static final Collection<Object[]> SORTING_ALGORITHMS = Arrays.asList(
            new Object[]{new Bubblesort<Integer>()},
            new Object[]{new Quicksort<Integer>()},
            new Object[]{new Insertionsort<Integer>()},
            new Object[]{new Selectionsort<Integer>()}
    );

    private final int LIST_SIZE = 100;

    private List<Integer> preSortedList = new ArrayList<>();
    private List<Integer> unSortedList = new ArrayList<>();
    private List<Integer> randomList = new ArrayList<>();

    public SortingAlgorithmTest(SortingAlgorithm<Integer> sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> sortingAlgorithms() {
        return SORTING_ALGORITHMS;
    }

    @Before
    public void setup() {
        // Create sorted list and an inversely sorted list
        for (int i = 0; i < LIST_SIZE; i++) {
            preSortedList.add(i);
            unSortedList.add(LIST_SIZE - i - 1);
        }

        // Create a list and keep creating it until it doesn't match the sorted list
        do {
            // Copy the sorted list so random elements can be added to new list
            List<Integer> temporaryList = new ArrayList<>(preSortedList);

            // While the temporary list is non-empty
            while (temporaryList.size() > 0) {
                // Get a random index
                int randomIndex = (int)(Math.random() * temporaryList.size());

                // Add the value at the random index to the random list
                randomList.add(temporaryList.get(randomIndex));

                // Remove the value from the temporary list
                temporaryList.remove(randomIndex);
            }
        } while (randomList == preSortedList);
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

    @Test
    public void sortRandomListReturnsSortedList() {
        // Actions
        List<Integer> sortedList = sortingAlgorithm.sort(randomList);

        // Assertions
        assertEquals(preSortedList, sortedList);
    }
}
