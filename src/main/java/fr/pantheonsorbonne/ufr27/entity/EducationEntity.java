package fr.pantheonsorbonne.ufr27.entity;

import java.util.Objects;

public class EducationEntity {
	private String name;

	public EducationEntity(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EducationEntity that = (EducationEntity) o;
		return Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
