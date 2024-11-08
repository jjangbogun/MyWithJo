package com.withJo.event.service;

import java.util.List;

import com.withJo.event.domain.EventVo;


public interface EventService {
	
	public List<EventVo> eventSelectList();
	public int eventUpdateLotto(EventVo eventVo);	
	public int eventUpdateDrawing(EventVo eventVo);	
	
}
