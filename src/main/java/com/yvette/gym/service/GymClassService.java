package com.yvette.gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yvette.gym.domain.GymClass;
import com.yvette.gym.domain.Member;
import com.yvette.gym.repository.IGymClassRepository;

@Service
public class GymClassService {

	@Autowired
	private IGymClassRepository iGymClassRepository; 
	
	public GymClass save (GymClass gymClass) {
		GymClass savedGymClass = iGymClassRepository.save(gymClass);
		
		return savedGymClass;
	}
	
	public GymClass getGymClass(Long id) {
		return iGymClassRepository.getOne(id);
	}
	
	public List<GymClass> getGymClassesByMember(Member member){
		return iGymClassRepository.findByStudents(member);
	}
	
	public List<GymClass> getAllGymClasses(){
		return iGymClassRepository.findAll();
	}
}
