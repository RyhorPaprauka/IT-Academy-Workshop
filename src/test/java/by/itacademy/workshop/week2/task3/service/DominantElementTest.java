package by.itacademy.workshop.week2.task3.service;

import by.itacademy.workshop.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DominantElementTest extends BaseTest {

    @Autowired
    private DominantElement dominantElement;

    @Test
    public void findDominantLogN() {
        List<Integer> list1 = Arrays.asList(10, 9, 9, 9, 10);
        List<Integer> list2 = Arrays.asList(3, 2, 2);
        List<Integer> list3 = Arrays.asList(2, 2, 1, 1, 1, 2, 2);

        assertEquals(dominantElement.findDominantLogN(list1), 9);
        assertEquals(dominantElement.findDominantLogN(list2), 2);
        assertEquals(dominantElement.findDominantLogN(list3), 2);
    }

    @Test
    public void findDominantN() {
        List<Integer> list1 = Arrays.asList(10, 9, 9, 9, 10);
        List<Integer> list2 = Arrays.asList(3, 2, 2);
        List<Integer> list3 = Arrays.asList(2, 2, 1, 1, 1, 2, 2);

        assertEquals(dominantElement.findDominantN(list1), 9);
        assertEquals(dominantElement.findDominantN(list2), 2);
        assertEquals(dominantElement.findDominantN(list3), 2);
    }
}
