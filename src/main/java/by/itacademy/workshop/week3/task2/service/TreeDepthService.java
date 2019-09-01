package by.itacademy.workshop.week3.task2.service;

import by.itacademy.workshop.week3.tree.BinaryTree;
import by.itacademy.workshop.week3.tree.Node;
import org.springframework.stereotype.Service;

@Service
public class TreeDepthService {

    public int getTreeDepthRecursive(BinaryTree tree) {
        return getDepthRecursive(tree.getRoot());
    }

    private int getDepthRecursive(Node current) {
        return current == null ? 0 :
                1 + Math.max(getDepthRecursive(current.getLeft()), getDepthRecursive(current.getRight()));
    }
}

