package by.itacademy.workshop.services;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListCombinerTest extends BaseTest {

    @Autowired
    private ListCombiner combiner;

    @Test
    public void sortTwoLists() {
        List<Integer> firstList = new LinkedList<Integer>(Arrays.asList(2, 3, 5));
        List<Integer> secondList = new LinkedList<Integer>(Arrays.asList(1, 3, 6, 7, 8, 9));

        combiner.sortTwoLists(firstList, secondList);

        List<Integer> expectedList = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 3, 5, 6, 7, 8, 9));
        List<Integer> cloneSecondList = new LinkedList<Integer>(Arrays.asList(1, 3, 6, 7, 8, 9));

        Assert.assertEquals(firstList, expectedList);
        Assert.assertEquals(secondList, cloneSecondList);
    }
}