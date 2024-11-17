package com.withJo.course.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.withJo.course.domain.CourseVo;

public interface CourseService {

	public List<CourseVo> getCourseList();
	public List<CourseVo> getCourseRecEndList();
	public List<CourseVo> courseCategorySelect(int courseAgeLimit);
	public CourseVo egetCourseDetailList(int courseNo);
	public Map<String, Object> getCourseDay(int courseNo);
	public List<CourseVo> getCategory(int courseAgeLimit);
	public void courseInsert(Map<String, Object>map, MultipartHttpServletRequest mhr) throws Exception;
	public void courseUpdate(Map<String, Object>map, MultipartHttpServletRequest mhr) throws Exception;
	public void courseDelete(Map<String, Object>map) throws Exception;
}
