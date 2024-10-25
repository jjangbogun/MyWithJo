package com.withJo.course.service;

import java.util.List;
import java.util.Map;

import com.withJo.course.domain.CourseVo;

public interface CourseService {

	public List<CourseVo> getCourseList();
	public List<CourseVo> courseCategorySelect(int courseAgeLimit);
	public CourseVo egetCourseDetailList(int courseNo);
}
