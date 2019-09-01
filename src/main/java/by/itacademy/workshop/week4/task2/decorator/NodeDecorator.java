package by.itacademy.workshop.week4.task2.decorator;

import by.itacademy.workshop.week3.tree.Node;
import by.itacademy.workshop.week3.tree.NodeParent;

public abstract class NodeDecorator<T extends Comparable<T>> extends NodeParent<T> {

    private NodeParent<T> nodeDecorated;

    public NodeDecorator(NodeParent<T> nodeDecorated) {
        this.nodeDecorated = nodeDecorated;
    }

    @Override
    public T getValue() {
        return nodeDecorated.getValue();
    }

    @Override
    public Node<T> getLeft() {
        return nodeDecorated.getLeft();
    }

    @Override
    public Node<T> getRight() {
        return nodeDecorated.getRight();
    }

    @Override
    public void setValue(T value) {
        nodeDecorated.setValue(value);
    }

    @Override
    public void setLeft(Node<T> left) {
        nodeDecorated.setLeft(left);
    }

    @Override
    public void setRight(Node<T> right) {
        nodeDecorated.setRight(right);
    }
}
