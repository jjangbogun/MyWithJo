package com.withJo.course.controller;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.withJo.course.domain.CourseVo;
import com.withJo.course.service.CourseService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/course")
public class CourseController {
	private Logger log = LoggerFactory.getLogger(CourseController.class);
	private final String logTitleMsg = "CourseContoller";
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
//	강의 view
	@GetMapping("/list")
	public ModelAndView getCourseList() {
		log.info(logTitleMsg);
		log.info("@GetMapping getCourseList");
		
		List<CourseVo> categoryList = courseService.getCategory();
		List<CourseVo> courseList = courseService.getCourseList();
		
//		model.addAttribute("courseList", couseList);
//		model.addAttribute("courseVo", courseVo);
		ModelAndView mav = new ModelAndView("course/CourseListView");
		mav.addObject("courseList", courseList);
		mav.addObject("categoryList", categoryList);
		
		return mav;
	}
	
// 강의 카테고리 리스트 
	@GetMapping("/list/{courseAgeLimit}")
	public ResponseEntity<List<CourseVo>> courseCategorySelect(@PathVariable int courseAgeLimit ,@RequestParam int categoryNo){
		log.info(logTitleMsg);
		log.info("@GetMapping courseCategorySelect", courseAgeLimit, categoryNo);
		
		List<CourseVo> courseList = courseService.courseCategorySelect(courseAgeLimit, categoryNo);
		System.out.println("courseList?!" + courseList);
		
		return ResponseEntity.ok(courseList);
	}
	
//	강의 리스트 디테일화면
	@GetMapping("/detail")
	public ModelAndView getCourseDetailList(@RequestParam int courseNo, Model model) {
		log.info(logTitleMsg);
		log.info("@GetMapping getCourseDetailList");
		
		CourseVo courseVo = courseService.egetCourseDetailList(courseNo);
		Map<String, Object> courseDay = courseService.getCourseDay(courseNo);
		
		ModelAndView mav = new ModelAndView("course/CourseDetailView");
		mav.addObject("courseVo", courseVo);
		mav.addObject("courseDay", courseDay);
		
		return mav;
	}
	
//	강의 디테일 예약화면
	@GetMapping("/detail/{courseNo}")
	public ResponseEntity<CourseVo> getCourseRes(@PathVariable int courseNo){
		log.info(logTitleMsg);
		log.info("@GetMapping getCourseDetailList",courseNo);
		
		CourseVo courseVo = courseService.egetCourseDetailList(courseNo);
		System.out.println(courseVo);
		
		return ResponseEntity.ok(courseVo);
	}
	
//	강의 리스트 카테고리 분류
	/*
	 * @GetMapping("/list/{categoryNo}") public ResponseEntity<List<CourseVo>>
	 * getCategory(@PathVariable int categoryNo, @RequestParam int courseAgeLimit){
	 * log.info(logTitleMsg); log.info("@GetMapping getCategory",categoryNo,
	 * courseAgeLimit);
	 * 
	 * List<CourseVo> categoryList = courseService.getCategory(categoryNo,
	 * courseAgeLimit);
	 * 
	 * return ResponseEntity.ok(categoryList); }
	 */
	
//	강의추가화면
	@GetMapping("/insert")
	public ModelAndView courseInsertView(){
		ModelAndView mav = new ModelAndView("course/CourseInsertView");
		
		return mav;
	}
	
	@PostMapping("/insert")
	public ResponseEntity<String> courseInsert(@RequestBody HashMap<String, Object> map,
			HttpServletRequest request){
		log.info(logTitleMsg);
		log.info("@GetMapping courseInsert",map);
		
		System.out.println("map: " + map);
		
		
		
		return ResponseEntity.ok("");
	}

}
