package by.itacademy.workshop.week2.task1.service;

import by.itacademy.workshop.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BracketServiceTest extends BaseTest {

    @Autowired
    private BracketService bracketService;

    @Test
    public void isBracketsCorrect() {
        String one = "()";
        String two = "({})[]";
        String three = ")(]";
        String four = "([)]";
        String five = "{[]}";
        String empty = "";

        assertTrue(bracketService.isBracketsCorrect(one));
        assertTrue(bracketService.isBracketsCorrect(two));
        assertFalse(bracketService.isBracketsCorrect(three));
        assertFalse(bracketService.isBracketsCorrect(four));
        assertTrue(bracketService.isBracketsCorrect(five));
        assertTrue(bracketService.isBracketsCorrect(empty));
    }
}
