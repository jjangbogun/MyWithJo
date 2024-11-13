package com.withJo.event.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.withJo.event.domain.EventVo;


@Repository
public class EventDaoImpl implements EventDao{

	@Autowired
	private SqlSession sqlSession;
	
	String namespace = "com.withJo.event.";

	@Override
	public List<EventVo> eventSelectList() {
		// TODO Auto-generated method stub

 		return sqlSession.selectList(namespace + "eventSelectList");
	}
	
	@Override
	public int eventUpdateLotto(EventVo eventVo) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "eventUpdateLotto", eventVo);
	}
	
	@Override
	public int eventUpdateDrawing(EventVo eventVo) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "eventUpdateDrawing", eventVo);
	}


	
}
