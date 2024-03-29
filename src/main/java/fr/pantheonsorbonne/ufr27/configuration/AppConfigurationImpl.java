package fr.pantheonsorbonne.ufr27.configuration;

import java.util.Collection;
import java.util.HashSet;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.assistedinject.FactoryModuleBuilder;

import fr.pantheonsorbonne.ufr27.action.AddTeacherAction;
import fr.pantheonsorbonne.ufr27.action.EducationAction;
import fr.pantheonsorbonne.ufr27.action.EducationActionFactory;
import fr.pantheonsorbonne.ufr27.entity.Course;
import fr.pantheonsorbonne.ufr27.entity.Student;
import fr.pantheonsorbonne.ufr27.entity.Teacher;

public class AppConfigurationImpl extends AbstractModule {


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
