package fr.pantheonsorbonne.ufr27.exception;

public class DuplicateStudentException extends EducationException {
    public DuplicateStudentException(String student_already_exist) {
        super(student_already_exist);
    }
}
