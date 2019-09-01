package by.itacademy.workshop.week4.task2.visitor;

import by.itacademy.workshop.week4.task2.Student;
import lombok.Getter;

@Getter
public class StudentsYearVisitor implements Visitor<Student> {

    private Student olderStudent;
    private Student youngerStudent;

    @Override
    public void visit(Student student) {
        if (olderStudent == null || student.getStudyYear() > olderStudent.getStudyYear()) {
            this.olderStudent = student;
        } else if (youngerStudent == null || student.getStudyYear() < youngerStudent.getStudyYear()) {
            this.youngerStudent = student;
        }
    }
}
