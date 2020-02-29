package com.yvette.gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yvette.gym.domain.GymClass;
import com.yvette.gym.domain.Member;

@Repository
public interface IGymClassRepository extends JpaRepository<GymClass, Long> {
	List<GymClass> findByStudents(Member member);
}
