package by.itacademy.workshop.week2.task2.service;

import by.itacademy.workshop.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AnagramServiceTest extends BaseTest {

    @Autowired
    private AnagramService anagramService;

    @Test
    public void findAnagrams() {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[][] anagrams = {{"ate", "eat", "tea"}, {"nat", "tan"}, {"bat"}};

        Assert.assertArrayEquals(anagramService.findAnagrams(words), anagrams);
    }
}

