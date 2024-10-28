package com.withJo.course.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withJo.course.dao.CourseDao;
import com.withJo.course.domain.CourseVo;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseDao courseDao;

	@Override
	public List<CourseVo> getCourseList() {
		// TODO Auto-generated method stub
		return courseDao.getCourseList();
	}

	@Override
	public List<CourseVo> courseCategorySelect(int courseAgeLimit) {
		// TODO Auto-generated method stub
		List<CourseVo> courseVo = courseDao.courseCategorySelect(courseAgeLimit);
		System.out.println("courseVo? " + courseVo);
		
		return courseVo;
	}

	@Override
	public CourseVo egetCourseDetailList(int courseNo) {
		// TODO Auto-generated method stub
		return courseDao.getCourseDetailList(courseNo);
	}

	
}
