package com.withJo.course.dao;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.withJo.course.domain.CourseVo;

public interface CourseDao {

	public List<CourseVo> getCourseList();
	public List<CourseVo> getCourseRecEndList();
	public List<CourseVo> courseCategorySelect(int courseAgeLimit);
	public CourseVo getCourseDetailList(int courseNo);
	public List<CourseVo> getCourseDay(int courseNo);
	public List<CourseVo> getCategory(int courseAgeLimit);
	public void courseInsert(Map<String, Object>map);
	public void courseDelete(Map<String, Object>map);
	public void courseUpdate(Map<String, Object>map);
	public void courseDayInsert(Map<String, Object>map);
	public void courseDayUpdate(Map<String, Object>map);
}
