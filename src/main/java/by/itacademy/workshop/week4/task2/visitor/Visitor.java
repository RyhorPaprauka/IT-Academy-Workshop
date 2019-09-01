package by.itacademy.workshop.week4.task2.visitor;

public interface Visitor<T extends Comparable<T>> {

    void visit(T t);
}
