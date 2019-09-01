package by.itacademy.workshop.week3.task3.service;

import by.itacademy.workshop.BaseTest;
import by.itacademy.workshop.week3.tree.BinaryTree;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class DFSearchAndConcatServiceTest extends BaseTest {

    @Autowired
    private DFSearchAndConcatService dfs;

    private final BinaryTree<Character> tree = new BinaryTree<>();

    @Before
    public void setUp() {
        tree.add('6');
        tree.add('4');
        tree.add('8');
        tree.add('3');
        tree.add('5');
        tree.add('7');
        tree.add('9');
    }

    @Test
    public void traverseTreeAndConcatElementsInOrder() {
        assertEquals("3456789", dfs.traverseTreeAndConcatElementsInOrder(tree));
    }

    @Test
    public void traverseTreeAndConcatElementsPreOrder() {
        assertEquals("6435879", dfs.traverseTreeAndConcatElementsPreOrder(tree));
    }

    @Test
    public void traverseTreeAndConcatElementsPostOrder() {
        assertEquals("3547986", dfs.traverseTreeAndConcatElementsPostOrder(tree));
    }
}
