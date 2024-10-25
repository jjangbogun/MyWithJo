package com.withJo.notice.service;

import java.util.List;

import com.withJo.notice.domain.NoticeVo;


public interface NoticeService {
	
	List<NoticeVo> noticeSelectList(int start, int end, String searchField, String searchKeyword);
	public int noticeTotalCount(String searchField, String searchKeyword);
	public int noticeInsertOne(NoticeVo noticeVo);
	public NoticeVo noticeSelectOne(int no);
	public int noticeUpdateOne(NoticeVo noticeVo);
	public int noticeDeleteOne(int no);
}
