package com.yvette.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yvette.gym.domain.Member;

@Repository
public interface IMemberRepository extends JpaRepository<Member, Long>{

	Member findByUsername (String username);
}
