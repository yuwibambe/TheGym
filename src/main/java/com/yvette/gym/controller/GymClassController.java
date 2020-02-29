package com.yvette.gym.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yvette.gym.domain.GymClass;
import com.yvette.gym.domain.Member;
import com.yvette.gym.service.GymClassService;

@Controller
public class GymClassController {

	@Autowired
	private GymClassService gymClassService;

	@RequestMapping("getMemberGymClasses")
	public ModelAndView getMemberGymClasses(HttpSession httpSession) {
		ModelAndView model = new ModelAndView();
		Member loggedMember = (Member) httpSession.getAttribute("session");

		if (loggedMember != null) {
			List<GymClass> classes = gymClassService.getGymClassesByMember(loggedMember);
			model.addObject("myClasses", classes);
			model.setViewName("memberGymClasses.jsp");
		} else {
			model.setViewName("login.jsp");
		}
		return model;
	}

	@RequestMapping("getGymClasses")
	public ModelAndView getGymClasses(HttpSession httpSession) {
		ModelAndView model = new ModelAndView();
		Member loggedMember = (Member) httpSession.getAttribute("session");

		if (loggedMember != null) {
			List<GymClass> classes = gymClassService.getAllGymClasses();
			model.addObject("classes", classes);
			model.setViewName("allClasses.jsp");
		} else {
			model.setViewName("login.jsp");
		}
		return model;
	}

	@RequestMapping("addClass")
	public ModelAndView addClass(@RequestParam(name = "classId") String id, HttpSession httpSession) {
		ModelAndView model = new ModelAndView();
		Member loggedMember = (Member) httpSession.getAttribute("session");

		if (loggedMember != null) {
			GymClass gymClass = gymClassService.getGymClass(Long.parseLong(id));
			if (gymClass.getStudents().isEmpty() || !gymClass.getStudents().contains(loggedMember)) {
				gymClass.getStudents().add(loggedMember);
				gymClass.setEnrolledStudents(gymClass.getEnrolledStudents() + 1);
				gymClass.setTotalStudents(gymClass.getTotalStudents() - 1);

				gymClassService.save(gymClass);
			}
			List<GymClass> classes = gymClassService.getAllGymClasses();
			model.addObject("classes", classes);
			model.setViewName("allClasses.jsp");
		} else {
			model.setViewName("login.jsp");
		}
		return model;
	}
	
	@RequestMapping("dropClass")
	public ModelAndView dropClass(@RequestParam(name = "classId") String id, HttpSession httpSession) {
		ModelAndView model = new ModelAndView();
		Member loggedMember = (Member) httpSession.getAttribute("session");

		if (loggedMember != null) {
			GymClass gymClass = gymClassService.getGymClass(Long.parseLong(id));
			if (!gymClass.getStudents().isEmpty() && gymClass.getStudents().contains(loggedMember)) {
				gymClass.getStudents().remove(loggedMember);
				gymClass.setEnrolledStudents(gymClass.getEnrolledStudents() - 1);
				gymClass.setTotalStudents(gymClass.getTotalStudents() + 1);

				gymClassService.save(gymClass);
			}
			List<GymClass> classes = gymClassService.getGymClassesByMember(loggedMember);
			model.addObject("myClasses", classes);
			model.setViewName("memberGymClasses.jsp");
		} else {
			model.setViewName("login.jsp");
		}
		return model;
	}
}
