package com.withJo.util.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.withJo.notice.domain.NoticeVo;
import com.withJo.notice.service.NoticeService;


@Controller
public class welcomePageController{
	private Logger log = LoggerFactory.getLogger(CourseController.class);
	private final String logTitleMsg = "welcomController";
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private NoticeService noticeService;

	@GetMapping("/")
	public ModelAndView index() {
		log.info(logTitleMsg);
		log.info("@GetMapping getCourseList");
		
		List<CourseVo> courseRecList = courseService.getCourseRecEndList();
		List<NoticeVo> noticeList = noticeService.noticeSelectListIndex();
		
		List<Integer> courseNoList = new ArrayList<>();
		for (CourseVo course : courseRecList) {
		    courseNoList.add(course.getCourseNo());
		}
		
		ModelAndView mav = new ModelAndView("/index");
		mav.addObject("courseRecList", courseRecList);
		mav.addObject("noticeList", noticeList);
		
		List<Map<String, Object>> courseDayList = new ArrayList<>();
		for (int i = 0; i < courseNoList.size(); i++) {
		    Map<String, Object> courseDay = courseService.getCourseDay(courseNoList.get(i));
		    courseDayList.add(courseDay);
		}
		mav.addObject("courseDayList", courseDayList);
		System.out.println("courseDayList" + courseDayList);
		return mav;
	}
	
	/*
	 * @GetMapping("/") public List<E> getindexinfo() { return new String(); }
	 */
	
	
}
