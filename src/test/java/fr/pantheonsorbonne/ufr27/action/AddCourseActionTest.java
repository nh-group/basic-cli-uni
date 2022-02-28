package fr.pantheonsorbonne.ufr27.action;

import fr.pantheonsorbonne.ufr27.configuration.AppConfigurationImpl;
import fr.pantheonsorbonne.ufr27.entity.Course;
import fr.pantheonsorbonne.ufr27.exception.EducationException;
import name.falgout.jeffrey.testing.junit.guice.GuiceExtension;
import name.falgout.jeffrey.testing.junit.guice.IncludeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.inject.Inject;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({GuiceExtension.class})
@IncludeModule(AppConfigurationTest.class)
class AddCourseActionTest {

    @Inject
    EducationActionFactory factory;

    @Inject
    Collection<Course> courses;

    @Test
    void perform() throws EducationException {
        factory.createCourseAction("courseName").perform();
        assertTrue(courses.contains(new Course("courseName")));
        assertThrows(EducationException.class, () -> {
            factory.createCourseAction("courseName").perform();
        });
        assertThrows(EducationException.class, () -> {
            factory.createCourseAction("").perform();
        });
        assertThrows(EducationException.class, () -> {
            factory.createCourseAction("  ").perform();
        });


    }
}