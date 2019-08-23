package by.itacademy.workshop.week3.task1.service;

import by.itacademy.workshop.BaseTest;
import by.itacademy.workshop.week3.task2.service.TreeDepthService;
import by.itacademy.workshop.week3.task3.service.DFSearchAndConcatService;
import by.itacademy.workshop.week3.task4.service.BFSearchAndConcatService;
import by.itacademy.workshop.week3.tree.BinaryTree;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.TreeSet;

public class GetTreeRootsCapacityTest extends BaseTest {

    @Autowired
    private TreeSizeService treeSizeService;
    @Autowired
    private TreeDepthService treeDepthService;
    @Autowired
    private DFSearchAndConcatService dfs;
    @Autowired
    private BFSearchAndConcatService bfs;

    @Test
    public void tryTree() {
        BinaryTree<Character> bt = new BinaryTree<>();

        bt.add('6');
        bt.add('4');
        bt.add('8');
        bt.add('3');
        bt.add('5');
        bt.add('7');
        bt.add('9');
        System.out.println(treeSizeService.getTreeSizeRecursive(bt));
        System.out.println(treeSizeService.getTreeSizeCyclically(bt));
        System.out.println("depth = " + treeDepthService.getTreeDepthRecursive(bt));

        System.out.println(treeSizeService.getTreeSizeRecursive(bt));
        System.out.println(treeSizeService.getTreeSizeCyclically(bt));
        System.out.println("depth = " + treeDepthService.getTreeDepthRecursive(bt));

        System.out.println();
        System.out.println("depth = " + treeDepthService.getTreeDepthRecursive(bt));
        System.out.println();
        System.out.println("depth = " + treeDepthService.getTreeDepthRecursive(bt));

        System.out.println();

        System.out.println(dfs.traverseTreeAndConcatElementsInOrder(bt));
        System.out.println(dfs.traverseTreeAndConcatElementsPreOrder(bt));
        String s = dfs.traverseTreeAndConcatElementsPostOrder(bt);
        System.out.println(dfs.traverseTreeAndConcatElementsPostOrder(bt));

        System.out.println(bfs.traverseTreeAndConcatElementsInBreadth(bt));
    }
}
