package by.itacademy.workshop.week3.task4.service;

import by.itacademy.workshop.week3.tree.BinaryTree;
import by.itacademy.workshop.week3.tree.Node;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class BFSearchAndConcatService {

    public String traverseTreeAndConcatElementsInBreadth(BinaryTree<Character> tree) {
        return traverseAndConcatInBreadth(tree.getRoot());
    }

    private String traverseAndConcatInBreadth(Node<Character> root) {
        StringBuilder string = new StringBuilder();

        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Node current = queue.remove();
                string.append(current.getValue());

                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
        }
        return string.toString();
    }
}
