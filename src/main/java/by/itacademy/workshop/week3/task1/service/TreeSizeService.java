package by.itacademy.workshop.week3.task1.service;

import by.itacademy.workshop.week3.tree.BinaryTree;
import by.itacademy.workshop.week3.tree.Node;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Queue;

@Service
public class TreeSizeService {

    public int getTreeSizeCyclically(BinaryTree tree) {
        Node current;
        int size = 0;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(tree.getRoot());

        while (!queue.isEmpty()) {
            current = queue.remove();
            size++;

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }

        }
        return size;
    }

    public int getTreeSizeRecursive(BinaryTree tree) {
        return getSizeRecursive(tree.getRoot());
    }

    private int getSizeRecursive(Node current) {
        return current == null ? 0 :
                getSizeRecursive(current.getLeft()) + 1 + getSizeRecursive(current.getRight());
    }
}
