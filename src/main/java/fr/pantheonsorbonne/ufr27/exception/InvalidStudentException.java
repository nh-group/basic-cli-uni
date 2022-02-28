package fr.pantheonsorbonne.ufr27.exception;

public class InvalidStudentException extends EducationException {
    public InvalidStudentException(String student_must_have_name) {
        super(student_must_have_name);
    }
}
