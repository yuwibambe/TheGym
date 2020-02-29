package com.yvette.gym.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yvette.gym.domain.Member;
import com.yvette.gym.domain.Workout;
import com.yvette.gym.repository.IWorkoutRepository;

@Service
public class WorkoutService {

	@Autowired
	private IWorkoutRepository iWorkoutRepository;

	public Workout save(Workout workout) {
		Workout savedWorkout = iWorkoutRepository.save(workout);

		return savedWorkout;
	}

	public Map<LocalDate, List<Workout>> getWorkouts(Member member) {
		List<Workout> workouts = iWorkoutRepository.findByMember(member);
		Map<LocalDate, List<Workout>> map = null;
		
		if (workouts != null) {
			map = workouts.stream()
					.collect(Collectors.groupingBy(Workout::getHappenedOn));
		}

		return map;
	}
}
