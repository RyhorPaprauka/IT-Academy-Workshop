package by.itacademy.workshop.week4.task2;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
@Builder
public class Student implements Comparable<Student> {

    private String name;
    private Integer studyYear;
    private List<Integer> marks = new ArrayList<>();

    @Override
    public int compareTo(Student student) {
        return Comparator.comparing(Student::getName)
                .thenComparingInt(Student::getStudyYear)
                .compare(this, student);
    }
}
