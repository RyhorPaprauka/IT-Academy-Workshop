package by.itacademy.workshop.week4.task2.decorator;

import by.itacademy.workshop.week3.tree.NodeParent;
import by.itacademy.workshop.week4.task2.visitor.Visitor;

public class VisitorNodeDecorator<T extends Comparable<T>> extends NodeDecorator<T> {

    public VisitorNodeDecorator(NodeParent<T> nodeDecorated) {
        super(nodeDecorated);
    }

    public void accept(Visitor<T> visitor) {
        visitor.visit(this.getValue());
    }
}
