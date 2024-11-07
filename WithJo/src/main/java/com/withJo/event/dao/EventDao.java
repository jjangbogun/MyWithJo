package com.withJo.event.dao;

import java.util.List;

import com.withJo.event.domain.EventVo;
import com.withJo.notice.domain.NoticeVo;


public interface EventDao {
	public List<EventVo> eventSelectList();
	public abstract int eventUpdateLotto(EventVo eventVo);
	public abstract int eventUpdateDrawing(EventVo eventVo);
}
