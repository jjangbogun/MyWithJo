package com.withJo.event.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.withJo.event.domain.EventVo;
import com.withJo.notice.domain.NoticeVo;


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
	public int eventUpdateOne(EventVo eventVo) {
		// TODO Auto-generated method stub
		System.out.println("오는지 체크");
		return sqlSession.update(namespace + "noticeUpdateOne", eventVo);
	}


	
}
