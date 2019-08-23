package by.itacademy.workshop.week2.task4.service;

import by.itacademy.workshop.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertArrayEquals;

public class ArraySortTest extends BaseTest {

    @Autowired
    private ArraySort arraySort;

    @Test
    public void sortOnlyOdd() {
        int[] array = {5, 3, 2, 8, 1, 4};
        int[] sortedArr = {1, 3, 2, 8, 5, 4};

        assertArrayEquals(arraySort.modifiedBubbleSort(array), sortedArr);
    }
}
