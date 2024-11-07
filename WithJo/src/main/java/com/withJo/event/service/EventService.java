package com.withJo.event.service;

import java.util.List;

import com.withJo.event.domain.EventVo;


public interface EventService {
	
	List<EventVo> eventSelectList();
	int eventUpdateLotto(EventVo eventVo);	
	int eventUpdateDrawing(EventVo eventVo);	
	
}
