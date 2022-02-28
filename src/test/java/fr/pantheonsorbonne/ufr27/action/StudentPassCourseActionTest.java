package fr.pantheonsorbonne.ufr27.action;

import fr.pantheonsorbonne.ufr27.entity.Course;
import fr.pantheonsorbonne.ufr27.entity.Student;
import fr.pantheonsorbonne.ufr27.exception.EducationException;
import name.falgout.jeffrey.testing.junit.guice.GuiceExtension;
import name.falgout.jeffrey.testing.junit.guice.IncludeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.inject.Inject;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({GuiceExtension.class})
@IncludeModule(AppConfigurationTest.class)
class StudentPassCourseActionTest {
    @Inject
    Collection<Course> courses;

    @Inject
    Collection<Student> students;

    @Inject
    EducationActionFactory factory;

    @Test
    void perform() throws EducationException {
        Student student = new Student("toto");
        students.add(student);
        Course course = new Course("java");
        courses.add(course);
        student.enroll(course);
        factory.studentPassCourseAction("toto", "java").perform();
        assertTrue(student.isKnown("java"));

        assertThrows(EducationException.class, () -> {
            factory.studentPassCourseAction("titi", "java").perform();
        });

        assertThrows(EducationException.class, () -> {
            factory.studentPassCourseAction("toto", "javi").perform();
        });

        assertThrows(EducationException.class, () -> {
            factory.studentPassCourseAction("glagla", "javi").perform();
        });


    }


}