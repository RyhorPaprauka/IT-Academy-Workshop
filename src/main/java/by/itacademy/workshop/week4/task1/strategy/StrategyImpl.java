package by.itacademy.workshop.week4.task1.strategy;

import by.itacademy.workshop.week3.tree.Node;

import java.util.Deque;

public enum StrategyImpl implements Strategy {
    IN_ORDER {
        @Override
        public <T extends Comparable<T>> void prepareStack(Node<T> node, Deque<Node<T>> nodes) {
            while (node != null) {
                nodes.push(node);
                node = node.getLeft();
            }
        }

        @Override
        public <T extends Comparable<T>> Node<T> next(Deque<Node<T>> nodes) {
            Node<T> next = nodes.pop();
            prepareStack(next.getRight(), nodes);

            return next;
        }
    },

    PRE_ORDER {
        @Override
        public <T extends Comparable<T>> void prepareStack(Node<T> node, Deque<Node<T>> nodes) {
            nodes.push(node);
        }

        @Override
        public <T extends Comparable<T>> Node<T> next(Deque<Node<T>> nodes) {
            Node<T> next = nodes.pop();
            if (next.getRight() != null) nodes.push(next.getRight());
            if (next.getLeft() != null) nodes.push(next.getLeft());

            return next;
        }
    },

    POST_ORDER {
        @Override
        public <T extends Comparable<T>> void prepareStack(Node<T> node, Deque<Node<T>> nodes) {
            while (node != null) {
                nodes.push(node);
                if (node.getLeft() != null) {
                    node = node.getLeft();
                } else {
                    node = node.getRight();
                }
            }
        }

        @Override
        public <T extends Comparable<T>> Node<T> next(Deque<Node<T>> nodes) {
            Node<T> next = nodes.pop();
            if (!nodes.isEmpty()) {
                Node<T> top = nodes.peek();
                if (next == top.getLeft()) {
                    prepareStack(top.getRight(), nodes);
                }
            }
            return next;
        }
    },

    BFS {
        @Override
        public <T extends Comparable<T>> void prepareStack(Node<T> node, Deque<Node<T>> nodes) {
            nodes.push(node);
        }

        @Override
        public <T extends Comparable<T>> Node<T> next(Deque<Node<T>> nodes) {
            Node<T> next = nodes.pop();
            if (next.getLeft() != null) {
                nodes.add(next.getLeft());
            }
            if (next.getRight() != null) {
                nodes.add(next.getRight());
            }
            return next;
        }
    }
}

