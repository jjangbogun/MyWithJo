package com.withJo.notice.dao;

import java.util.List;

import com.withJo.notice.domain.NoticeVo;


public interface NoticeDao {
	List<NoticeVo> noticeSelectList(int start, int end, String searchField, String searchKeyword);
	List<NoticeVo> noticeSelectListIndex();
	public int noticeTotalCount(String searchField, String searchKeyword);
	public abstract int noticeInsertOne(NoticeVo noticeVo);
	public NoticeVo noticeSelectOne(int no);
	public abstract int noticeUpdateOne(NoticeVo noticeVo);
	public abstract int noticeDeleteOne(int no);
}
