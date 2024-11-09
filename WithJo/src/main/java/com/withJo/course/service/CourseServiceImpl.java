package com.withJo.course.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.withJo.course.dao.CourseDao;
import com.withJo.course.domain.CourseVo;
import com.withJo.util.FileUtils;

import jakarta.transaction.Transactional;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private FileUtils fileUtils;

	@Override
	public List<CourseVo> getCourseList() {
		// TODO Auto-generated method stub
		return courseDao.getCourseList();
	}

	@Override
	public List<CourseVo> courseCategorySelect(int courseAgeLimit,int categoryNo) {
		// TODO Auto-generated method stub
		List<CourseVo> courseVo = courseDao.courseCategorySelect(courseAgeLimit, categoryNo);
		
		return courseVo;
	}

	@Override
	public CourseVo egetCourseDetailList(int courseNo) {
		// TODO Auto-generated method stub
		return courseDao.getCourseDetailList(courseNo);
	}

	@Override
	public Map<String, Object> getCourseDay(int courseNo) {
		// TODO Auto-generated method stub
		Map<String, Object> resultMap = new HashMap<>();
		
		List<CourseVo> courseDay = courseDao.getCourseDay(courseNo);
		resultMap.put("courseDay", courseDay);
		
		return resultMap;
	}

	@Override
	public List<CourseVo> getCategory() {
		// TODO Auto-generated method stub
		
		List<CourseVo> categoryList = courseDao.getCategory();
		
		return categoryList;
	}

	@Transactional
	@Override
	public void courseInsert(Map<String, Object>map, MultipartHttpServletRequest mhr) throws Exception{
		// TODO Auto-generated method stub
		
		Map<String, Object> fileList =
				fileUtils.insertFileInfo(mhr);
		
		
		map.put("courseMainImage", fileList.get("storedFileName"));
		
		courseDao.courseInsert(map);
		
		map.put("courseNo", map.get("courseNo"));
		System.out.println("map.get(\"courseNo\")" + map.get("courseNo"));
		courseDao.courseDayInsert(map);
	}


}
