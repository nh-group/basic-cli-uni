package fr.pantheonsorbonne.ufr27.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class Student extends EducationEntity {

	private Collection<Course> enrolledCourses = new HashSet<>();
	private Collection<Course> passedCourses = new HashSet<Course>();

	public Student(String studentName) {
		super(studentName);
	}

	public void enroll(Course... courses) {
		Arrays.stream(courses).forEach((Course c) -> this.enrolledCourses.add(c));

	}

	public boolean isEnrolled(Course course) {
		return this.enrolledCourses.contains(course);
	}

	public void pass(Course... courses) {
		Arrays.stream(courses).filter((Course c) -> this.enrolledCourses.contains(c))
				.forEach((Course c) -> this.passedCourses.add(c));

	}

	public boolean isKnown(String skill) {
		return this.passedCourses.stream().anyMatch((Course c) -> c.getName().startsWith(skill));
	}


}
