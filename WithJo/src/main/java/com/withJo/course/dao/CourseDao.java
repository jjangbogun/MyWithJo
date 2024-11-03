package com.withJo.course.dao;

import java.util.List;
import java.util.Map;

import com.withJo.course.domain.CourseVo;

public interface CourseDao {

	public List<CourseVo> getCourseList();
	public List<CourseVo> courseCategorySelect(int courseAgeLimit);
	public CourseVo getCourseDetailList(int courseNo);
	public List<CourseVo> getCourseDay(int courseNo);
	public List<CourseVo> getCategory();
	public List<CourseVo> getCategoryNo(int categoryNo);
}
