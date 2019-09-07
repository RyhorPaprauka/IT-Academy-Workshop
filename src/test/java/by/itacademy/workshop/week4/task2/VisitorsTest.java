package by.itacademy.workshop.week4.task2;

import by.itacademy.workshop.BaseTest;
import by.itacademy.workshop.week3.tree.BinaryTree;
import by.itacademy.workshop.week4.task1.iterator.TreeIterator;
import by.itacademy.workshop.week4.task1.strategy.StrategyImpl;
import by.itacademy.workshop.week4.task2.visitor.StudentsMarkVisitor;
import by.itacademy.workshop.week4.task2.visitor.StudentsYearVisitor;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class VisitorsTest extends BaseTest {
    private final BinaryTree<Student> tree = new BinaryTree<>();

    @Before
    public void setUp() {
        tree.add(new Student("Vasya", 2, Arrays.asList(3, 5, 6, 8, 9)));
        tree.add(new Student("Petya", 3, Arrays.asList(3, 5, 5, 8, 7)));
        tree.add(new Student("Jenya", 1, Arrays.asList(1, 2, 6, 7, 4)));
        tree.add(new Student("Sasha", 5, Arrays.asList(3, 5, 3, 10, 9)));
        tree.add(new Student("Anna", 4, Arrays.asList(10, 9, 8, 9, 9)));
        tree.add(new Student("Gosha", 3, Arrays.asList(3, 5, 8, 8, 9)));
        tree.add(new Student("Gleb", 1, Arrays.asList(3, 5, 2, 8, 9)));
    }

    @Test
    public void visitorsTest() {
        TreeIterator<Student> iterator = tree.iterator(StrategyImpl.IN_ORDER);

        StudentsMarkVisitor visitor = new StudentsMarkVisitor();
        StudentsYearVisitor visitor2 = new StudentsYearVisitor();

        iterator.addVisitor(visitor);
        iterator.addVisitor(visitor2);

        while (iterator.hasNext()) {
            iterator.next();
        }
        assertEquals(visitor.getAverageMarks().size(), 7);
        assertEquals(visitor.getUniversityAvgMark().intValue(), 6);
        assertEquals(visitor2.getOlderStudent().getName(), "Sasha");
        assertEquals(visitor2.getYoungerStudent().getName(), "Gleb");
    }
}
