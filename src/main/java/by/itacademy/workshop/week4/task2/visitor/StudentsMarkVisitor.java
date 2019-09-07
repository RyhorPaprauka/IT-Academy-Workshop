package by.itacademy.workshop.week4.task2.visitor;

import by.itacademy.workshop.week4.task2.Student;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class StudentsMarkVisitor implements Visitor<Student> {

    private Map<Student, Double> averageMarks = new HashMap<>();

    @Override
    public void visit(Student student) {
        averageMarks.put(student,
                student.getMarks().stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(Double.NaN));
    }

    public Double getUniversityAvgMark() {
        return averageMarks.values().stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(Double.NaN);
    }
}
