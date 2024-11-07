package com.withJo.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withJo.event.dao.EventDao;
import com.withJo.event.domain.EventVo;
import com.withJo.notice.domain.NoticeVo;


@Service
public class EventServiceImpl implements EventService{

	@Autowired
	public EventDao eventDao;

	@Override
	public List<EventVo> eventSelectList() {
		// TODO Auto-generated method stub
		return eventDao.eventSelectList();
	}
	
	@Override
	public int eventUpdateLotto(EventVo eventVo) {
		// TODO Auto-generated method stub
		return eventDao.eventUpdateLotto(eventVo);
	}
	
	@Override
	public int eventUpdateDrawing(EventVo eventVo) {
		// TODO Auto-generated method stub
		return eventDao.eventUpdateDrawing(eventVo);
	}


}
