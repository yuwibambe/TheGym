package com.yvette.gym.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yvette.gym.domain.Member;
import com.yvette.gym.domain.Workout;
import com.yvette.gym.service.WorkoutService;

@Controller
public class WorkoutController {

	@Autowired
	private WorkoutService workoutService;
	
	@PostMapping("addworkout")
	public ModelAndView save (Workout workout, HttpSession httpSession) {
		ModelAndView model = new ModelAndView();
		Member loggedMember = (Member) httpSession.getAttribute("session");
		
		if(loggedMember!=null) {
			workout.setHappenedOn(LocalDate.now());
			workout.assignMember(loggedMember);
			
			workoutService.save(workout);
			Map<LocalDate, List<Workout>> map =  workoutService.getWorkouts(loggedMember);
			
			model.addObject("message", "Workout saved successfully");
			model.addObject("workouts", map);
			model.setViewName("workouts.jsp");
		}else {
			model.setViewName("login.jsp");
		}
		return model;
	}
	
	@RequestMapping("getWorkouts")
	public ModelAndView getWorkouts(HttpSession httpSession) {
		ModelAndView model = new ModelAndView();
		Member loggedMember = (Member) httpSession.getAttribute("session");
		
		if(loggedMember!=null) {
			Map<LocalDate, List<Workout>> map =  workoutService.getWorkouts(loggedMember);
			
			model.addObject("workouts", map);
			model.setViewName("workouts.jsp");
		}else {
			model.setViewName("login.jsp");
		}
		return model;
	}
	
}
