package by.itacademy.workshop.week4.task1.iterator;

import by.itacademy.workshop.BaseTest;
import by.itacademy.workshop.week3.tree.BinaryTree;
import by.itacademy.workshop.week4.task1.strategy.StrategyImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class TreeIteratorTest extends BaseTest {

    private final BinaryTree<Integer> tree = new BinaryTree<>();

    @Before
    public void setUp() {
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);
    }

    @Test
    public void inOrderIteration() {
        Iterator<Integer> iterator = tree.iterator(StrategyImpl.IN_ORDER);
        List<Integer> list = new ArrayList<>();

        while (iterator.hasNext()) {
            list.add(iterator.next());
        }

        assertArrayEquals(new Integer[]{3, 4, 5, 6, 7, 8, 9}, list.toArray());
    }

    @Test
    public void preOrderIteration() {
        Iterator<Integer> iterator = tree.iterator(StrategyImpl.PRE_ORDER);
        List<Integer> list = new ArrayList<>();

        while (iterator.hasNext()) {
            list.add(iterator.next());
        }

        assertArrayEquals(new Integer[]{6, 4, 3, 5, 8, 7, 9}, list.toArray());
    }

    @Test
    public void postOrderIteration() {
        Iterator<Integer> iterator = tree.iterator(StrategyImpl.POST_ORDER);
        List<Integer> list = new ArrayList<>();

        while (iterator.hasNext()) {
            list.add(iterator.next());
        }

        assertArrayEquals(new Integer[]{3, 5, 4, 7, 9, 8, 6}, list.toArray());
    }

    @Test
    public void levelOrderIteration() {
        Iterator<Integer> iterator = tree.iterator(StrategyImpl.BFS);
        List<Integer> list = new ArrayList<>();

        while (iterator.hasNext()) {
            list.add(iterator.next());
        }

        assertArrayEquals(new Integer[]{6, 4, 8, 3, 5, 7, 9}, list.toArray());
    }
}
