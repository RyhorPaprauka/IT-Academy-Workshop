package by.itacademy.workshop.week4.task1.strategy;

import by.itacademy.workshop.week3.tree.Node;

import java.util.Deque;

public interface Strategy {

    <T extends Comparable<T>> void prepareStack(Node<T> node, Deque<Node<T>> nodes);

    <T extends Comparable<T>> Node<T> next(Deque<Node<T>> nodes);
}

