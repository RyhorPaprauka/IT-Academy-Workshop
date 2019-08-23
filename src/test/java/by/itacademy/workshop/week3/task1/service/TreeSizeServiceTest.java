package by.itacademy.workshop.week3.task1.service;

import by.itacademy.workshop.BaseTest;
import by.itacademy.workshop.week3.tree.BinaryTree;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class TreeSizeServiceTest extends BaseTest {

    @Autowired
    private TreeSizeService treeSizeService;

    @Test
    public void getTreeSizeCyclically() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);

        assertEquals(7, treeSizeService.getTreeSizeCyclically(tree));
    }

    @Test
    public void getTreeSizeRecursive() {
        BinaryTree<Character> tree = new BinaryTree<>();
        tree.add('6');
        tree.add('4');
        tree.add('8');
        tree.add('3');
        tree.add('5');
        tree.add('7');
        tree.add('9');
        tree.delete('3');

        assertEquals(6, treeSizeService.getTreeSizeCyclically(tree));
    }
}
