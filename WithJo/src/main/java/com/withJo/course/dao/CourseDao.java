package com.withJo.course.dao;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.withJo.course.domain.CourseVo;

public interface CourseDao {

	public List<CourseVo> getCourseList();
	public List<CourseVo> courseCategorySelect(int courseAgeLimit, int categoryNo);
	public CourseVo getCourseDetailList(int courseNo);
	public List<CourseVo> getCourseDay(int courseNo);
	public List<CourseVo> getCategory();
	public void courseInsert(Map<String, Object>map);
	public void courseDayInsert(Map<String, Object>map);
}
