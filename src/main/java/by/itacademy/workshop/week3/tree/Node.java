package by.itacademy.workshop.week3.tree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T extends Comparable<T>> {

    private T value;
    private Node<T> left;
    private Node<T> right;

    Node(T value) {
        this.value = value;
        right = null;
        left = null;
    }
}
