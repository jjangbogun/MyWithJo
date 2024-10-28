package com.withJo.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withJo.board.domain.BoardVo;
import com.withJo.notice.dao.NoticeDao;
import com.withJo.notice.domain.NoticeVo;


@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	public NoticeDao noticeDao;

	@Override
	public List<NoticeVo> noticeSelectList(int start, int end, String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		return noticeDao.noticeSelectList(start, end, searchField, searchKeyword);
	}

	@Override
	public int noticeTotalCount(String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		return noticeDao.noticeTotalCount(searchField, searchKeyword);
	}
	
	@Override
	public int noticeInsertOne(NoticeVo noticeVo) {
		// TODO Auto-generated method stub
		return noticeDao.noticeInsertOne(noticeVo);
	}
	
	@Override
	public NoticeVo noticeSelectOne(int no) {
		// TODO Auto-generated method stub
		return noticeDao.noticeSelectOne(no);
	}
	
	@Override
	public int noticeUpdateOne(NoticeVo noticeVo) {
		// TODO Auto-generated method stub
		return noticeDao.noticeUpdateOne(noticeVo);
	}
	
	@Override
	public int noticeDeleteOne(int no) {
		// TODO Auto-generated method stub
		return noticeDao.noticeDeleteOne(no);
	}
}
