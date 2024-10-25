package com.withJo.course.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.withJo.course.domain.CourseVo;

@Repository
public class CourseDaoImpl implements CourseDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	String namespace = "mappers.withJo.course.";

	@Override
	public List<CourseVo> getCourseList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "getCourseList");
	}

	@Override
	public List<CourseVo> courseCategorySelect(int courseAgeLimit) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "courseCategorySelect",courseAgeLimit);
	}

	@Override
	public CourseVo getCourseDetailList(int courseNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "getCourseDetailList",courseNo);
	}

	
}
