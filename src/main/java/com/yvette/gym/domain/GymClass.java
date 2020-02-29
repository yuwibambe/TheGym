package com.yvette.gym.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GYMCLASSES")
public class GymClass {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private int totalStudents;
	private int enrolledStudents;
	private String dayOfWeek;
	private String fromHour;
	private String toHour;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
	  name = "member_class",
	  joinColumns = @JoinColumn(name = "class_id"), 
	  inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<Member> students = new ArrayList<>();
	
	public GymClass () {}

	public GymClass(String name, int totalStudents, int enrolledStudents, String dayOfWeek, String fromHour, String toHour) {
		super();
		this.name = name;
		this.totalStudents = totalStudents;
		this.enrolledStudents = enrolledStudents;
		this.dayOfWeek = dayOfWeek;
		this.fromHour = fromHour;
		this.toHour = toHour;
	}

	public int getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(int enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public List<Member> getStudents() {
		return students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalStudents() {
		return totalStudents;
	}

	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getFromHour() {
		return fromHour;
	}

	public void setFromHour(String fromHour) {
		this.fromHour = fromHour;
	}

	public String getToHour() {
		return toHour;
	}

	public void setToHour(String toHour) {
		this.toHour = toHour;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dayOfWeek == null) ? 0 : dayOfWeek.hashCode());
		result = prime * result + ((fromHour == null) ? 0 : fromHour.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((toHour == null) ? 0 : toHour.hashCode());
		result = prime * result + totalStudents;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GymClass other = (GymClass) obj;
		if (dayOfWeek == null) {
			if (other.dayOfWeek != null)
				return false;
		} else if (!dayOfWeek.equals(other.dayOfWeek))
			return false;
		if (fromHour == null) {
			if (other.fromHour != null)
				return false;
		} else if (!fromHour.equals(other.fromHour))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (toHour == null) {
			if (other.toHour != null)
				return false;
		} else if (!toHour.equals(other.toHour))
			return false;
		if (totalStudents != other.totalStudents)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GymClass [id=" + id + ", name=" + name + ", totalStudents=" + totalStudents + ", dayOfWeek=" + dayOfWeek
				+ ", fromHour=" + fromHour + ", toHour=" + toHour + "]";
	}
	
}
