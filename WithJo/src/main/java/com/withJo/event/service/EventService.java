package com.withJo.event.service;

import java.util.List;

import com.withJo.event.domain.EventVo;
import com.withJo.notice.domain.NoticeVo;


public interface EventService {
	
	List<EventVo> eventSelectList();	
	public int eventUpdateOne(EventVo eventVo);
}
