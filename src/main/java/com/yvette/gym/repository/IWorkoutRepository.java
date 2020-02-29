package com.yvette.gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yvette.gym.domain.Member;
import com.yvette.gym.domain.Workout;

@Repository
public interface IWorkoutRepository extends JpaRepository<Workout, Long>{
	List<Workout> findByMember(Member member);
}
