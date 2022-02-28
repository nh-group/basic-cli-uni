package fr.pantheonsorbonne.ufr27.action;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import fr.pantheonsorbonne.ufr27.entity.Course;
import fr.pantheonsorbonne.ufr27.entity.Student;
import fr.pantheonsorbonne.ufr27.entity.Teacher;

import java.util.Collection;
import java.util.HashSet;

public class AppConfigurationTest extends AbstractModule {


    protected void configure() {
        install(new FactoryModuleBuilder()
                .build(EducationActionFactory.class));
    }


    @Singleton
    @Provides
    public Collection<Teacher> getTeachers() {
        return new HashSet<Teacher>();
    }


    @Singleton
    @Provides
    public Collection<Student> getStudents() {
        return new HashSet<Student>();
    }


    @Singleton
    @Provides
    public Collection<Course> getCourses() {
        return new HashSet<Course>();
    }
}
