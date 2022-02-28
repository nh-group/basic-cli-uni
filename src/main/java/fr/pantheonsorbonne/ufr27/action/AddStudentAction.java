package fr.pantheonsorbonne.ufr27.action;

import java.util.Collection;
import java.util.regex.Pattern;

import javax.inject.Inject;

import com.google.inject.assistedinject.Assisted;

import fr.pantheonsorbonne.ufr27.entity.Course;
import fr.pantheonsorbonne.ufr27.entity.Student;
import fr.pantheonsorbonne.ufr27.exception.DuplicateCourseException;
import fr.pantheonsorbonne.ufr27.exception.DuplicateStudentException;
import fr.pantheonsorbonne.ufr27.exception.InvalidCourseException;
import fr.pantheonsorbonne.ufr27.exception.InvalidStudentException;

public class AddStudentAction implements EducationAction {


    @Inject
    private Collection<Student> students;

    private String studentName;

    @Inject
    public AddStudentAction(@Assisted("studentName") String studentName) {
        this.studentName = studentName;
    }

    public void perform() throws DuplicateStudentException, InvalidStudentException {

        Student student = new Student(this.studentName);
        if (students.contains(student)) {
            throw new DuplicateStudentException("student already exist");
        }
        if (student.getName() == null || student.getName().isBlank()) {
            throw new InvalidStudentException("student must have a name");
        }
        students.add(new Student(this.studentName));


    }

}
