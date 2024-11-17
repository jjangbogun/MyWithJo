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
	public List<CourseVo> courseCategorySelect(int courseAgeLimit) {
		// TODO Auto-generated method stub
		List<CourseVo> courseVo = courseDao.courseCategorySelect(courseAgeLimit);
		
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
	public List<CourseVo> getCategory(int courseAgeLimit) {
		// TODO Auto-generated method stub
		
		List<CourseVo> categoryList = courseDao.getCategory(courseAgeLimit);
		
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

	@Override
	public List<CourseVo> getCourseRecEndList() {
		// TODO Auto-generated method stub
		return courseDao.getCourseRecEndList();
	}

	@Override
	public void courseDelete(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		
		courseDao.courseDelete(map);
	}

	@Override
	public void courseUpdate(Map<String, Object> map, MultipartHttpServletRequest mhr) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("mhr" + mhr);
		/*
		 * Map<String, Object> fileList = fileUtils.insertFileInfo(mhr);
		 * if(fileList.get("storedFileName") != null) { map.put("courseMainImage",
		 * fileList.get("storedFileName")); }
		 */
		 if (!mhr.getFileMap().isEmpty()) {
		        Map<String, Object> fileList = fileUtils.insertFileInfo(mhr);
		        if (fileList != null && fileList.get("storedFileName") != null) {
		            map.put("courseMainImage", fileList.get("storedFileName"));
		        }
		    } else {
		        // 파일이 업로드되지 않았다면 courseMainImage를 null로 설정
		        // 이렇게 하면 MyBatis 쿼리에서 해당 필드를 업데이트하지 않습니다.
		        map.put("courseMainImage", null);
		    }
		
		courseDao.courseUpdate(map);
		
		courseDao.courseDayUpdate(map);
	}


}
