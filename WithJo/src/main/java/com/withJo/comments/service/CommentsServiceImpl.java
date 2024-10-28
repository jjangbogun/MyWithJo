package com.withJo.comments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withJo.board.dao.BoardDao;
import com.withJo.board.domain.BoardVo;
import com.withJo.comments.dao.CommentsDao;
import com.withJo.comments.domain.CommentsVo;
import com.withJo.notice.dao.NoticeDao;
import com.withJo.notice.domain.NoticeVo;


@Service
public class CommentsServiceImpl implements CommentsService{

	@Autowired
	public CommentsDao commentsDao;

	@Override
	public List<CommentsVo> commentsSelectList(int boardNo) {
		// TODO Auto-generated method stub
		return commentsDao.commentsSelectList(boardNo);
	}
	
	@Override
	public int commentsInsertOne(CommentsVo commentsVo) {
		// TODO Auto-generated method stub
		return commentsDao.commentsInsertOne(commentsVo);
	}
	
	@Override
	public int commentsDeleteOne(int commentsNo) {
		// TODO Auto-generated method stub
		return commentsDao.commentsDeleteOne(commentsNo);
	}

}
