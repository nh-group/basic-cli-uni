package fr.pantheonsorbonne.ufr27.action;

import java.util.Collection;

import javax.inject.Inject;

import com.google.inject.assistedinject.Assisted;

import fr.pantheonsorbonne.ufr27.entity.Course;
import fr.pantheonsorbonne.ufr27.exception.DuplicateCourseException;
import fr.pantheonsorbonne.ufr27.exception.EducationException;
import fr.pantheonsorbonne.ufr27.exception.InvalidCourseException;

public class AddCourseAction implements EducationAction {

    @Inject
    private Collection<Course> courses;

    private String courseName;

    @Inject
    public AddCourseAction(@Assisted("courseName") String studentName) {
        this.courseName = studentName;
    }

    public void perform() throws EducationException {
        Course c = new Course(this.courseName);
        if (courses.contains(c)) {
            throw new DuplicateCourseException("course already exist");
        }
        if (c.getName() == null || c.getName().isBlank()) {
            throw new InvalidCourseException("course already exist");
        }
        courses.add(new Course(this.courseName));

    }

}
