package by.itacademy.workshop.week4.task1.iterator;

import by.itacademy.workshop.week3.tree.BinaryTree;
import by.itacademy.workshop.week3.tree.Node;
import by.itacademy.workshop.week3.tree.NodeParent;
import by.itacademy.workshop.week4.task1.strategy.Strategy;
import by.itacademy.workshop.week4.task2.decorator.VisitorNodeDecorator;
import by.itacademy.workshop.week4.task2.visitor.Visitor;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class TreeIterator<T extends Comparable<T>> implements Iterator<T> {

    private BinaryTree<T> tree;
    private Strategy strategy;
    private Deque<Node<T>> nodes = new ArrayDeque<>();
    private Set<Visitor<T>> visitors = new HashSet<>();

    public TreeIterator(BinaryTree<T> tree, Strategy strategy) {
        this.tree = tree;
        this.strategy = strategy;
        strategy.prepareStack(tree.getRoot(), nodes);
    }

    @Override
    public boolean hasNext() {
        return !nodes.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Node<T> next = strategy.next(nodes);
        visitorsAccept(next);

        return next.getValue();
    }

    private void visitorsAccept(NodeParent<T> node) {
        for (Visitor<T> visitor : visitors) {
            node = new VisitorNodeDecorator<>(node);
            ((VisitorNodeDecorator<T>) node).accept(visitor);
        }
    }

    public void addVisitor(Visitor<T> visitor) {
        visitors.add(visitor);
    }
}
