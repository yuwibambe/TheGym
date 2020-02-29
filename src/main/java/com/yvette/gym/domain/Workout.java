package com.yvette.gym.domain;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WORKOUTS")
public class Workout {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDate happenedOn;
	private String workoutType;
	private long weight;
	private int sets;
	private int reps;
	
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="member_id", nullable=false)
	private Member member;
	
	public Workout () {}
	
	public void assignMember(Member member) {
		this.member = member;
	}

	public Workout(LocalDate happenedOn, String workoutType, long weight, int sets, int reps) {
		super();
		this.happenedOn = happenedOn;
		this.workoutType = workoutType;
		this.weight = weight;
		this.sets = sets;
		this.reps = reps;
	}

	public LocalDate getHappenedOn() {
		return happenedOn;
	}

	public void setHappenedOn(LocalDate happenedOn) {
		this.happenedOn = happenedOn;
	}

	public Long getId() {
		return id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getWorkoutType() {
		return workoutType;
	}

	public void setWorkoutType(String workoutType) {
		this.workoutType = workoutType;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	@Override
	public String toString() {
		return "Workout [id=" + id + ", happenedOn=" + happenedOn + ", workoutType=" + workoutType + ", weight="
				+ weight + ", sets=" + sets + ", reps=" + reps + ", member=" + member + "]";
	}
	
	
}
