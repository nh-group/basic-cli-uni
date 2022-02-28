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
class AddStudentActionTest {

    @Inject
    EducationActionFactory factory;

    @Inject
    Collection<Student> students;

    @Test
    void perform() throws EducationException {
        factory.createStudentAction("student Name").perform();
        assertTrue(students.contains(new Student("student Name")));
        assertThrows(EducationException.class, () -> {
            factory.createStudentAction("student Name").perform();
        });
        assertThrows(EducationException.class, () -> {
            factory.createStudentAction("").perform();
        });
        assertThrows(EducationException.class, () -> {
            factory.createStudentAction("    ").perform();
        });
    }
}