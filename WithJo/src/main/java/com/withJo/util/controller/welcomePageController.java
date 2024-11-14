package com.withJo.util.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.withJo.course.controller.CourseController;
import com.withJo.course.domain.CourseVo;
import com.withJo.course.service.CourseService;


@Controller
public class welcomePageController{
	private Logger log = LoggerFactory.getLogger(CourseController.class);
	private final String logTitleMsg = "welcomController";
	
	@Autowired
	private CourseService courseService;

	@GetMapping("/")
	public ModelAndView index() {
		log.info(logTitleMsg);
		log.info("@GetMapping getCourseList");
		
		List<CourseVo> courseList = courseService.getCourseList();
		
		ModelAndView mav = new ModelAndView("/index");
		mav.addObject("courseList", courseList);
		
		return mav;
	}
	
	/*
	 * @GetMapping("/") public List<E> getindexinfo() { return new String(); }
	 */
	
	
}
