package by.itacademy.workshop.services;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class PhoneNumberFormatterTest extends BaseTest {

    @Autowired
    private PhoneNumberFormatter formatter;

    @Test
    public void formatWithRegex() {
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        Assert.assertEquals(formatter.formatWithRegex(number), "(123) 456-7890");
    }

    @Test
    public void formatWithoutRegex() {
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        Assert.assertEquals(formatter.formatWithoutRegex(number), "(123) 456-7890");
    }
}