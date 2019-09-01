package by.itacademy.workshop.week3.task3.service;

import by.itacademy.workshop.week3.tree.BinaryTree;
import by.itacademy.workshop.week3.tree.Node;
import org.springframework.stereotype.Service;

@Service
public class DFSearchAndConcatService {

    public String traverseTreeAndConcatElementsInOrder(BinaryTree<Character> tree) {
        return traverseAndConcatInOrder(tree.getRoot(), new StringBuilder())
                .toString();
    }

    private StringBuilder traverseAndConcatInOrder(Node<Character> node, StringBuilder string) {
        if (node != null) {
            traverseAndConcatInOrder(node.getLeft(), string);
            string.append(node.getValue());
            traverseAndConcatInOrder(node.getRight(), string);
        }
        return string;
    }

    public String traverseTreeAndConcatElementsPreOrder(BinaryTree<Character> tree) {
        return traverseAndConcatPreOrder(tree.getRoot(), new StringBuilder())
                .toString();
    }

    private StringBuilder traverseAndConcatPreOrder(Node<Character> node, StringBuilder string) {
        if (node != null) {
            string.append(node.getValue());
            traverseAndConcatPreOrder(node.getLeft(), string);
            traverseAndConcatPreOrder(node.getRight(), string);
        }
        return string;
    }

    public String traverseTreeAndConcatElementsPostOrder(BinaryTree<Character> tree) {
        return traverseAndConcatPostOrder(tree.getRoot(), new StringBuilder())
                .toString();
    }

    private StringBuilder traverseAndConcatPostOrder(Node<Character> node, StringBuilder string) {
        if (node != null) {
            traverseAndConcatPostOrder(node.getLeft(), string);
            traverseAndConcatPostOrder(node.getRight(), string);
            string.append(node.getValue());
        }
        return string;
    }
}
