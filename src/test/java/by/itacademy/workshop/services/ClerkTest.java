package by.itacademy.workshop.services;

import by.itacademy.workshop.entity.Banknote;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static by.itacademy.workshop.entity.Banknote.FIFTY_DOLL;
import static by.itacademy.workshop.entity.Banknote.HUNDRED_DOLL;
import static by.itacademy.workshop.entity.Banknote.TWENTYFIFE_DOLL;

public class ClerkTest extends BaseTest {

    @Autowired
    private Clerk clerk;

    @Test
    public void serveQueue() {
        List<Banknote> firstQueue = new ArrayList<>(
                Arrays.asList(TWENTYFIFE_DOLL, TWENTYFIFE_DOLL, FIFTY_DOLL, HUNDRED_DOLL, TWENTYFIFE_DOLL, FIFTY_DOLL));
        List<Banknote> secondQueue = new ArrayList<>(
                Arrays.asList(TWENTYFIFE_DOLL, FIFTY_DOLL, TWENTYFIFE_DOLL, HUNDRED_DOLL, FIFTY_DOLL));

        Assert.assertTrue(clerk.serveQueue(firstQueue));
        Assert.assertFalse(clerk.serveQueue(secondQueue));
    }
}