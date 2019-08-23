package by.itacademy.workshop.week3.task2.service;

import by.itacademy.workshop.BaseTest;
import by.itacademy.workshop.week3.tree.BinaryTree;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class TreeDepthServiceTest extends BaseTest {

    @Autowired
    private TreeDepthService treeDepthService;

    @Test
    public void getTreeDepthRecursive() {
        BinaryTree<Double> tree = new BinaryTree<>();
        tree.add(6.2);
        tree.add(6.3);
        tree.add(6.0);
        tree.add(5.4);
        tree.add(7.1);
        tree.add(1.0);
        tree.add(0.2);

        assertEquals(5, treeDepthService.getTreeDepthRecursive(tree));
        tree.delete(5.4);
        assertEquals(4, treeDepthService.getTreeDepthRecursive(tree));
    }
}
