package by.itacademy.workshop.week3.tree;

public class Node<T extends Comparable<T>> extends NodeParent<T> {

    Node(T value) {
        super.setValue(value);
    }
}
