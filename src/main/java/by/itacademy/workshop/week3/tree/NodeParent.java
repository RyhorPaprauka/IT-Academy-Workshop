package by.itacademy.workshop.week3.tree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class NodeParent<T extends Comparable<T>> {

    private T value;
    private Node<T> left;
    private Node<T> right;
}
