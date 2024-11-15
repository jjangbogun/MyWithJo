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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.withJo.course.domain.CourseVo;
import com.withJo.course.service.CourseService;
import com.withJo.member.domain.MemberVo;
import com.withJo.member.service.MemberService;
import com.withJo.util.FileUpload;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/course")
public class CourseController {
	private Logger log = LoggerFactory.getLogger(CourseController.class);
	private final String logTitleMsg = "CourseContoller";
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private MemberService memberService;
	
//	강의 view
	@GetMapping("/list")
	public ModelAndView getCourseList() {
		log.info(logTitleMsg);
		log.info("@GetMapping getCourseList");
		
		List<CourseVo> courseList = courseService.getCourseList();
		
//		model.addAttribute("courseList", couseList);
//		model.addAttribute("courseVo", courseVo);
		ModelAndView mav = new ModelAndView("course/CourseListView");
		mav.addObject("courseList", courseList);
		return mav;
	}
	
// 강의 카테고리 리스트 
	@GetMapping("/list/{courseAgeLimit}")
	public ResponseEntity<Map<String, Object>> courseCategorySelect(@PathVariable int courseAgeLimit){
		log.info(logTitleMsg);
		log.info("@GetMapping courseCategorySelect", courseAgeLimit);
		
		Map<String, Object> resultMap = new HashMap<>();
		
		List<CourseVo> courseList = courseService.courseCategorySelect(courseAgeLimit);
		List<CourseVo> categoryList = courseService.getCategory(courseAgeLimit);
		resultMap.put("courseList", courseList);
		resultMap.put("categoryList", categoryList);
		
		System.out.println("courseList?!" + courseList);
		System.out.println("categoryList?!" + categoryList);
		
		
		return ResponseEntity.ok(resultMap);
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
	public ResponseEntity<Map<String, Object>> getCourseRes(@PathVariable int courseNo, @RequestParam int memberNo){
		log.info(logTitleMsg);
		log.info("@GetMapping getCourseDetailList",courseNo);
		
		Map<String, Object> resultMap = new HashMap<>();
		
		CourseVo courseVo = courseService.egetCourseDetailList(courseNo);
		MemberVo memberVo = memberService.memberSelectOne(memberNo);
		
		resultMap.put("courseVo", courseVo);
		resultMap.put("memberVo", memberVo);
		
		return ResponseEntity.ok(resultMap);
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
	public ResponseEntity<String> courseInsert(@RequestParam("params") String formData,
												MultipartHttpServletRequest mhr) throws Exception{
		log.info(logTitleMsg);
		log.info("@GetMapping courseInsert",formData, mhr);
		
		System.out.println("formData: " + formData);
		System.out.println("file: " + mhr);
		ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> courseData = mapper.readValue(formData, Map.class);
		courseService.courseInsert(courseData, mhr);
		
		return ResponseEntity.ok("강의 등록 성공");
	}
	
	@PostMapping("/delete")
	public ResponseEntity<String> courseDelete(@RequestBody Map<String, Object> jsonMap) throws Exception{
		log.info(logTitleMsg);
		log.info("@@PostMapping courseDelete",jsonMap);
		
		courseService.courseDelete(jsonMap);
		
		return ResponseEntity.ok("강의가 삭제되었습니다.");
	}


}
